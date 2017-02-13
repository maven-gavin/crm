package com.yuanbao.crm.admin.sys.user.entity;

/**
 * Created by gewen on 2017/1/21.
 */
public enum UserStatus {
    normal("正常状态"), blocked("封禁状态");

    private final String info;

    private UserStatus(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
