package com.yuanbao.crm.admin.maintain.notification.repository;

import com.yuanbao.crm.admin.maintain.notification.entity.NotificationData;
import com.yuanbao.crm.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by gewen on 2017/1/22.
 */
public interface NotificationDataRepository extends BaseRepository<NotificationData, Long> {

    @Modifying
    @Query("update NotificationData o set o.read=true where userId=?1")
    void markReadAll(Long userId);
}
