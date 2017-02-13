package com.yuanbao.crm.common.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>性别</p>
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-14 下午2:12
 * <p>Version: 1.0
 */
public enum Sex {

    male("男"), female("女");
    private final String info;

    private Sex(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
