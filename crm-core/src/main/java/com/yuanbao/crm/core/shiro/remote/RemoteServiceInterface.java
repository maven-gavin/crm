package com.yuanbao.crm.core.shiro.remote;

import org.apache.shiro.session.Session;

import java.io.Serializable;

/**
 * Created by gewen on 2017/1/11.
 */
public interface RemoteServiceInterface {
    Session getSession(String appKey, Serializable sessionId);
    Serializable createSession(Session session);
    void updateSession(String appKey,Session session);
    void deleteSession(String appKey,Session session);

    PermissionContext getPermissions(String appKey, String username);
}
