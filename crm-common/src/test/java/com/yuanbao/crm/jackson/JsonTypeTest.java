package com.yuanbao.crm.jackson;

import com.google.common.collect.Maps;
import com.yuanbao.crm.common.entity.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-3-20 下午5:07
 * <p>Version: 1.0
 */
public class JsonTypeTest {

    /*@Test
    public void test() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping();

        Map<Object, Object> map = Maps.newHashMap();

        User value1 = new User();
        value1.setId(1L);
        value1.setUsername("zhang");
        value1.setBaseInfo(new BaseInfo());
        value1.getBaseInfo().setSex(Sex.female);
        value1.getBaseInfo().setBirthday(new Date());
        value1.getBaseInfo().setRealname("zhangsan");
        SchoolInfo s1 = new SchoolInfo();
        s1.setType(SchoolType.high_school);
        value1.addSchoolInfo(s1);

        User value2 = new User();
        value2.setId(2L);
        value2.setUsername("li");
        value2.setBaseInfo(new BaseInfo());
        value2.getBaseInfo().setSex(Sex.male);
        value2.getBaseInfo().setBirthday(new Date());
        value2.getBaseInfo().setRealname("lisan");
        SchoolInfo s2 = new SchoolInfo();
        s2.setType(SchoolType.high_school);
        value2.addSchoolInfo(s2);

        map.put("1", value1);
        map.put("2", value2);

        String jsonStr = objectMapper.writeValueAsString(map);

        System.out.println(jsonStr);

        Map jsonObj = objectMapper.readValue(jsonStr, HashMap.class);


        Assert.assertEquals(jsonObj.get("1"), map.get("1"));
        Assert.assertEquals(jsonObj.get("2"), map.get("2"));

        User actualValue1 = (User) jsonObj.get("1");

        Assert.assertEquals(value1.getBaseInfo().getBirthday(), actualValue1.getBaseInfo().getBirthday());

        Assert.assertEquals(value1.getBaseInfo().getSex(), actualValue1.getBaseInfo().getSex());


    }*/

}