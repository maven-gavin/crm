package com.yuanbao.crm.admin.sys.user.web.controller;

/**
 * Created by gewen on 2017/1/22.
 */

import com.yuanbao.crm.common.web.controller.BaseCRUDController;
import com.yuanbao.crm.admin.sys.user.entity.UserStatus;
import com.yuanbao.crm.admin.sys.user.entity.UserStatusHistory;
import com.yuanbao.crm.admin.sys.user.service.UserStatusHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-28 下午4:29
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "/admin/sys/user/statusHistory")
public class UserStatusHistoryController extends BaseCRUDController<UserStatusHistory, Long> {

    public UserStatusHistoryController() {
        setListAlsoSetCommonData(true);
        setResourceIdentity("sys:userStatusHistory");
    }


    @Override
    protected void setCommonData(Model model) {
        model.addAttribute("statusList", UserStatus.values());
    }

}
