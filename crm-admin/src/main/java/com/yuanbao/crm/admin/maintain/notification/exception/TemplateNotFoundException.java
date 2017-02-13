package com.yuanbao.crm.admin.maintain.notification.exception;

/**
 * Created by gewen on 2017/1/22.
 */
public class TemplateNotFoundException extends TemplateException {
    public TemplateNotFoundException(String templateName) {
        super("notification.template.not.found", new Object[] {templateName});
    }
}
