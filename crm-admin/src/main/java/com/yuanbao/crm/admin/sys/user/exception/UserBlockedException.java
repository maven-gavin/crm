package com.yuanbao.crm.admin.sys.user.exception;

/**
 * Created by gewen on 2017/1/21.
 */
public class UserBlockedException extends UserException {
    public UserBlockedException(String reason) {
        super("user.blocked", new Object[]{reason});
    }
}
