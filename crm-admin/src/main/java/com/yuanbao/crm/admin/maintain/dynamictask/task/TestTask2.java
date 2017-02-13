package com.yuanbao.crm.admin.maintain.dynamictask.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by gewen on 2017/1/22.
 */
public class TestTask2 {

    @Autowired
    private ApplicationContext ctx;

    public void run() {
        System.out.println("====hello test task2::" + ctx);
    }
}
