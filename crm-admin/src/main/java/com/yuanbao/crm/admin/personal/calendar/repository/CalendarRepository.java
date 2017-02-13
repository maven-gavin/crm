package com.yuanbao.crm.admin.personal.calendar.repository;

import com.yuanbao.crm.admin.personal.calendar.entity.Calendar;
import com.yuanbao.crm.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * Created by gewen on 2017/1/22.
 */
public interface CalendarRepository extends BaseRepository<Calendar, Long> {

    @Query("select count(id) from Calendar where userId=?1 and ((startDate=?2 and (startTime is null or startTime<?3)) or (startDate > ?2 and startDate<=(?2+?4)) or (startDate<?2 and (startDate+length)>?2) or ((startDate+length)=?2 and (endTime is null or endTime>?3)))")
    Long countRecentlyCalendar(Long userId, Date nowDate, Date nowTime, Integer interval);
}

