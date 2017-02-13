package com.yuanbao.crm.admin.sys.user.exception;

/**
 * Created by gewen on 2017/1/21.
 */
public class UserNotExistsException extends UserException {

    public UserNotExistsException() {
        super("user.not.exists", null);
    }
}
