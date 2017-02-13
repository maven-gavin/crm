package com.yuanbao.crm.admin.sys.group.entity;

/**
 * Created by gewen on 2017/1/21.
 */
public enum GroupType {

    user("用户组"), organization("组织机构组");

    private final String info;

    private GroupType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
