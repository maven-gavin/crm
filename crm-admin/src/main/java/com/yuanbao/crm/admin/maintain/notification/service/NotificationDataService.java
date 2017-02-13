package com.yuanbao.crm.admin.maintain.notification.service;

import com.yuanbao.crm.admin.maintain.notification.entity.NotificationData;
import com.yuanbao.crm.admin.maintain.notification.repository.NotificationDataRepository;
import com.yuanbao.crm.common.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * Created by gewen on 2017/1/22.
 */
@Service
public class NotificationDataService extends BaseService<NotificationData, Long> {

    private NotificationDataRepository getNotificationDataRepository() {
        return (NotificationDataRepository) baseRepository;
    }


    public void markReadAll(final Long userId) {
        getNotificationDataRepository().markReadAll(userId);
    }


    public void markRead(final Long notificationId) {
        NotificationData data = findOne(notificationId);
        if(data == null || data.getRead().equals(Boolean.TRUE)) {
            return;
        }
        data.setRead(Boolean.TRUE);
        update(data);
    }
}