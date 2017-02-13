package com.yuanbao.crm.admin.sys.user.web.controller;

import com.yuanbao.crm.admin.sys.user.entity.UserLastOnline;
import com.yuanbao.crm.common.web.controller.BaseCRUDController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gewen on 2017/1/22.
 */
@Controller
@RequestMapping(value = "/admin/sys/user/lastOnline")
public class UserLastOnlineController extends BaseCRUDController<UserLastOnline, Long> {

    public UserLastOnlineController() {
        setResourceIdentity("sys:userLastOnline");
    }
}