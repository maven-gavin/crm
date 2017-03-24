package com.yuanbao.crm.common.web.form;

import com.yuanbao.crm.common.web.form.bind.SearchBindStatus;
import org.springframework.web.servlet.support.BindStatus;

import javax.servlet.jsp.JspException;

/**
 * 取值时
 * 1、先取parameter
 * 2、如果找不到再找attribute (page--->request--->session--->application)
 * Created by gewen on 2017/1/19.
 */
public class OptionsTag extends org.springframework.web.servlet.tags.form.OptionsTag{

}
