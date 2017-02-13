package com.yuanbao.crm.common.web.jcaptcha;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gewen on 2017/1/20.
 */
public class JCaptcha {
    public static final CrmManageableImageCaptchaService captchaService =
            new CrmManageableImageCaptchaService(new FastHashMapCaptchaStore(),new GMailEngine(),180,100000, 75000);

    public static boolean validateResponse(HttpServletRequest request,String userCaptchaResponse){
        if(request.getSession(false) == null) return false;

        boolean validated = false;

        try {
            String id = request.getSession().getId();
            validated = captchaService.validateResponseForID(id, userCaptchaResponse).booleanValue();
        } catch (CaptchaServiceException e) {
            e.printStackTrace();
        }
        return validated;
    }

    public static boolean hasCaptcha(HttpServletRequest request, String userCaptchaResponse) {
        if(request.getSession(false) == null) return false;

        boolean validated = false;
        try {
            String id = request.getSession().getId();
            validated = captchaService.hasCaptcha(id, userCaptchaResponse);
        } catch (CaptchaServiceException e) {
            e.printStackTrace();
        }
        return validated;

    }

}
