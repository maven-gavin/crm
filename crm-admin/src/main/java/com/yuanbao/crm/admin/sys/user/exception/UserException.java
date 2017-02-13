package com.yuanbao.crm.admin.sys.user.exception;

import com.yuanbao.crm.common.exception.BaseException;

/**
 * Created by gewen on 2017/1/21.
 */
public class UserException extends BaseException {

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }

}
