package com.yuanbao.crm.admin.sys.app.entity;

import com.yuanbao.crm.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by gewen on 2017/2/4.
 */
@Entity
@Table(name = "sys_app")
public class App extends BaseEntity<Long> {

    /**
     * 应用名
     */
    private String name;

    /**
     * 应用标志
     */
    @Column(name = "app_key")
    private String appKey;

    /**
     * 应用密钥
     */
    @Column(name = "app_secret")
    private String appSecret;

    /**
     * 显示表示可用，不显示表示不可用
     */
    @Column(name = "is_show")
    private Boolean show = Boolean.FALSE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
