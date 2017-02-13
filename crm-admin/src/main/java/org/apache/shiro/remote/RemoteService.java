package org.apache.shiro.remote;

import com.yuanbao.crm.admin.sys.auth.service.AuthService;
import com.yuanbao.crm.admin.sys.auth.service.UserAuthService;
import com.yuanbao.crm.admin.sys.user.service.UserService;
import com.yuanbao.crm.core.shiro.remote.PermissionContext;
import com.yuanbao.crm.core.shiro.remote.RemoteServiceInterface;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.OnlineSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by gewen on 2017/2/9.
 */
public class RemoteService implements RemoteServiceInterface {
    @Autowired
    private OnlineSessionDAO onlineSessionDAO;

    @Autowired
    private UserAuthService userAuthService;

    @Override
    public Session getSession(String appKey, Serializable sessionId) {
        return onlineSessionDAO.readSession(sessionId);
    }

    @Override
    public Serializable createSession(Session session) {
        return onlineSessionDAO.create(session);
    }

    @Override
    public void updateSession(String appKey, Session session) {
        onlineSessionDAO.update(session);
    }

    @Override
    public void deleteSession(String appKey, Session session) {
        onlineSessionDAO.delete(session);
    }

    @Override
    public PermissionContext getPermissions(String appKey, String username) {
        PermissionContext ctx = new PermissionContext();
        ctx.setRoles(userAuthService.findStringRoles(appKey,username));
        ctx.setPermissions(userAuthService.findStringPermissions(appKey,username));
        return ctx;
    }
}
