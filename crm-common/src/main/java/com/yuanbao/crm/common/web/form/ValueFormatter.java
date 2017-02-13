package com.yuanbao.crm.common.web.form;

import org.springframework.util.ObjectUtils;
import org.springframework.web.util.HtmlUtils;

/**
 * Created by gewen on 2017/1/19.
 */
public class ValueFormatter {
    public String getDisplayString(Object value, boolean htmlEscape) {
        String displayString = ObjectUtils.getDisplayString(value);
        return (htmlEscape ? HtmlUtils.htmlEscape(displayString) : displayString);
    }
}
