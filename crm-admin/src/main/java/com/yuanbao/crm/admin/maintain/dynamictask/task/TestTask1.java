package com.yuanbao.crm.admin.maintain.dynamictask.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by gewen on 2017/1/22.
 */
@Service("testTask1")
public class TestTask1 {

    @Autowired
    private ApplicationContext ctx;

    public void run() {
        System.out.println("====hello test task1::" + ctx);
    }
}

