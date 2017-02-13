package com.yuanbao.crm.admin.maintain.notification.repository;

import com.yuanbao.crm.admin.maintain.notification.entity.NotificationTemplate;
import com.yuanbao.crm.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by gewen on 2017/1/22.
 */
public interface NotificationTemplateRepository extends BaseRepository<NotificationTemplate, Long> {

    @Query("from NotificationTemplate o where name=?1")
    NotificationTemplate findByName(String name);
}

