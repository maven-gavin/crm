package com.yuanbao.crm.admin.sys.user.service;

import com.yuanbao.crm.admin.sys.user.entity.UserLastOnline;
import com.yuanbao.crm.admin.sys.user.repository.UserLastOnlineRepository;
import com.yuanbao.crm.common.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * Created by gewen on 2017/1/22.
 */
@Service
public class UserLastOnlineService extends BaseService<UserLastOnline, Long> {

    private UserLastOnlineRepository getUserLastOnlineRepository() {
        return (UserLastOnlineRepository) baseRepository;
    }


    public UserLastOnline findByUserId(Long userId) {
        return getUserLastOnlineRepository().findByUserId(userId);
    }

    public void lastOnline(UserLastOnline lastOnline) {
        UserLastOnline dbLastOnline = findByUserId(lastOnline.getUserId());

        if (dbLastOnline == null) {
            dbLastOnline = lastOnline;
        } else {
            UserLastOnline.merge(lastOnline, dbLastOnline);
        }
        dbLastOnline.incLoginCount();
        dbLastOnline.incTotalOnlineTime();
        //相对于save or update
        save(dbLastOnline);
    }
}