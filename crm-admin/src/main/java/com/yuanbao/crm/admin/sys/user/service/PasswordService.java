package com.yuanbao.crm.admin.sys.user.service;

import com.yuanbao.crm.admin.sys.user.entity.User;
import com.yuanbao.crm.admin.sys.user.exception.UserPasswordNotMatchException;
import com.yuanbao.crm.admin.sys.user.exception.UserPasswordRetryLimitExceedException;
import com.yuanbao.crm.admin.sys.user.utils.UserLogUtils;
import com.yuanbao.crm.common.utils.security.Md5Utils;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by gewen on 2017/1/21.
 */
@Service
public class PasswordService {

    @Autowired
    private CacheManager ehcacheManager;

    private Cache loginRecordCache;

    @Value(value = "${user.password.maxRetryCount}")
    private int maxRetryCount = 10;

    public void setMaxRetryCount(int maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    @PostConstruct
    public void init() {
        loginRecordCache = ehcacheManager.getCache("loginRecordCache");
    }

    public void validate(User user, String password) {
        String username = user.getUsername();

        int retryCount = 0;

        Element cacheElement = loginRecordCache.get(username);
        if (cacheElement != null) {
            retryCount = (Integer) cacheElement.getObjectValue();
            if (retryCount >= maxRetryCount) {
                UserLogUtils.log(
                        username,
                        "passwordError",
                        "password error, retry limit exceed! password: {},max retry count {}",
                        password, maxRetryCount);
                throw new UserPasswordRetryLimitExceedException(maxRetryCount);
            }
        }

        if (!matches(user, password)) {
            loginRecordCache.put(new Element(username, ++retryCount));
            UserLogUtils.log(
                    username,
                    "passwordError",
                    "password error! password: {} retry count: {}",
                    password, retryCount);
            throw new UserPasswordNotMatchException();
        } else {
            clearLoginRecordCache(username);
        }
    }

    public boolean matches(User user, String newPassword) {
        return user.getPassword().equals(encryptPassword(user.getUsername(), newPassword, user.getSalt()));
    }

    public void clearLoginRecordCache(String username) {
        loginRecordCache.remove(username);
    }


    public String encryptPassword(String username, String password, String salt) {
        return Md5Utils.hash(username + password + salt);
    }


    public static void main(String[] args) {
        System.out.println(new PasswordService().encryptPassword("monitor", "123456", "iY71e4d123"));
    }
}
