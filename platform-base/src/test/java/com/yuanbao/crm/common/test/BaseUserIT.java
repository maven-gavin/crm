package com.yuanbao.crm.common.test;

import com.yuanbao.crm.common.entity.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by gewen on 2017/1/20.
 */
public abstract class BaseUserIT extends BaseIT {

    public User createUser() {
        User user = new User();
        user.setUsername("zhangkaitao$$$" + System.nanoTime() + RandomStringUtils.random(10));
        user.setPassword("123456");
        user.setRegisterDate(new Date());
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setRealname("zhangkaitao");
        baseInfo.setSex(Sex.male);
        baseInfo.setBirthday(new Timestamp(System.currentTimeMillis()));
        baseInfo.setAge(15);
        user.setBaseInfo(baseInfo);

        SchoolInfo primary = new SchoolInfo();
        primary.setName("abc");
        primary.setType(SchoolType.primary_school);
        user.addSchoolInfo(primary);

        SchoolInfo secondary = new SchoolInfo();
        secondary.setName("bcd");
        secondary.setType(SchoolType.secondary_school);
        user.addSchoolInfo(secondary);

        SchoolInfo high = new SchoolInfo();
        high.setName("cde");
        high.setType(SchoolType.high_school);
        user.addSchoolInfo(high);

        SchoolInfo university = new SchoolInfo();
        university.setName("def");
        university.setType(SchoolType.university);
        user.addSchoolInfo(university);

        return user;
    }


}