package com.yuanbao.crm.common.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by gewen on 2017/1/20.
 */
@ContextConfiguration({"classpath:spring-common.xml", "classpath:spring-test.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class BaseIT extends AbstractTransactionalJUnit4SpringContextTests{
    @PersistenceContext
    protected EntityManager entityManager;


    public void clear() {
        flush();
        entityManager.clear();
    }

    public void flush() {
        entityManager.flush();
    }


    protected String nextRandom() {
        return System.currentTimeMillis() + RandomStringUtils.randomNumeric(5);
    }
}
