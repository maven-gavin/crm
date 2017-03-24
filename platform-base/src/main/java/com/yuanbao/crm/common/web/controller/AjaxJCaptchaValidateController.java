package com.yuanbao.crm.common.web.controller;

import com.yuanbao.crm.common.web.jcaptcha.JCaptcha;
import com.yuanbao.crm.common.web.validate.ValidateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gewen on 2017/1/20.
 */
@Controller
@RequestMapping("/jcaptcha-validate")
public class AjaxJCaptchaValidateController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object jqueryValidationEngineValidate(
            HttpServletRequest request,
            @RequestParam(value = "fieldId",required = false) String fieldId,
            @RequestParam(value = "fieldValue", required = false) String fieldValue
    ) {
        ValidateResponse response = ValidateResponse.newInstance();
        if (JCaptcha.hasCaptcha(request, fieldValue) == false) {
            response.validateFail(fieldId,messageSource.getMessage("jcaptcha.validate.error", null, null));
        }else {
            response.validateSuccess(fieldId,messageSource.getMessage("jcaptcha.validate.success", null, null));
        }
        return response.result();
    }
}
