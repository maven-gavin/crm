package com.yuanbao.crm.admin.sys.user.service;

import com.yuanbao.crm.admin.sys.user.entity.UserOnline;
import com.yuanbao.crm.admin.sys.user.repository.UserOnlineRepository;
import com.yuanbao.crm.common.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by gewen on 2017/1/22.
 */
@Service
public class UserOnlineService extends BaseService<UserOnline, String> {

    private UserOnlineRepository getUserOnlineRepository() {
        return (UserOnlineRepository) baseRepository;
    }

    /**
     * 上线
     *
     * @param userOnline
     */
    public void online(UserOnline userOnline) {
        save(userOnline);
    }

    /**
     * 下线
     *
     * @param sid
     */
    public void offline(String sid) {
        UserOnline userOnline = findOne(sid);
        if (userOnline != null) {
            delete(userOnline);
        }
        //游客 无需记录上次访问记录
        //此处使用数据库的触发器完成同步
//        if(userOnline.getUserId() == null) {
//            userLastOnlineService.lastOnline(UserLastOnline.fromUserOnline(userOnline));
//        }
    }

    /**
     * 批量下线
     *
     * @param needOfflineIdList
     */
    public void batchOffline(List<String> needOfflineIdList) {
        getUserOnlineRepository().batchDelete(needOfflineIdList);
    }

    /**
     * 无效的UserOnline
     *
     * @return
     */
    public Page<UserOnline> findExpiredUserOnlineList(Date expiredDate, Pageable pageable) {
        return getUserOnlineRepository().findExpiredUserOnlineList(expiredDate, pageable);
    }


}