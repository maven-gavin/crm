package com.yuanbao.crm.admin.maintain.icon.entity;

/**
 * 图标类型
 * Created by gewen on 2017/1/22.
 */
public enum IconType {
    css_class("css类图标"), upload_file("文件图标"), css_sprite("css精灵图标");

    private final String info;

    private IconType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
