package com.yuanbao.crm.admin.personal.message.exception;

import com.yuanbao.crm.common.exception.BaseException;

/**
 * Created by gewen on 2017/1/22.
 */
public class MessageException extends BaseException {

    public MessageException(String code, Object[] args) {
        super("personal", code, args);
    }
}