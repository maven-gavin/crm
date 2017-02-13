package com.yuanbao.crm.admin.maintain.notification.service;

import com.yuanbao.crm.admin.maintain.notification.entity.NotificationTemplate;
import com.yuanbao.crm.admin.maintain.notification.repository.NotificationTemplateRepository;
import com.yuanbao.crm.common.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * Created by gewen on 2017/1/22.
 */
@Service
public class NotificationTemplateService extends BaseService<NotificationTemplate, Long> {

    private NotificationTemplateRepository getNotificationTemplateRepository() {
        return (NotificationTemplateRepository) baseRepository;
    }


    public NotificationTemplate findByName(final String name) {
        return getNotificationTemplateRepository().findByName(name);
    }
}

