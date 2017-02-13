package com.yuanbao.crm.admin.sys.app.web.controller;

import com.yuanbao.crm.admin.sys.app.entity.App;
import com.yuanbao.crm.common.Constants;
import com.yuanbao.crm.common.entity.enums.AvailableEnum;
import com.yuanbao.crm.common.web.controller.BaseCRUDController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gewen on 2017/2/4.
 */
@Controller
@RequestMapping(value = "/admin/sys/app")
public class AppController extends BaseCRUDController<App,Long> {
    public AppController() {
        setResourceIdentity("sys:app");
    }

    @Override
    protected void setCommonData(Model model) {
        super.setCommonData(model);
        model.addAttribute("availableList", AvailableEnum.values());
    }

    @RequestMapping(value = "/changeStatus/{newStatus}")
    public String changeStatus(
            HttpServletRequest request,
            @PathVariable("newStatus") Boolean newStatus,
            @RequestParam("ids") Long[] ids
    ){
        this.permissionList.assertHasUpdatePermission();

        for (Long id : ids){
            App app = baseService.findOne(id);
            app.setShow(newStatus);
            baseService.update(app);
        }

        return "redirect:" + request.getAttribute(Constants.BACK_URL);
    }
}
