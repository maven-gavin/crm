package com.yuanbao.crm.admin.maintain.notification.exception;

import com.yuanbao.crm.common.exception.BaseException;

/**
 * Created by gewen on 2017/1/22.
 */
public class TemplateException extends BaseException {

    public TemplateException(final String code, final Object[] args) {
        super("notification", code, args);
    }
}