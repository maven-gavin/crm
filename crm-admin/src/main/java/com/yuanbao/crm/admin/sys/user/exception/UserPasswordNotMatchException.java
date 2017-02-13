package com.yuanbao.crm.admin.sys.user.exception;

/**
 * Created by gewen on 2017/1/21.
 */
public class UserPasswordNotMatchException extends UserException {

    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}