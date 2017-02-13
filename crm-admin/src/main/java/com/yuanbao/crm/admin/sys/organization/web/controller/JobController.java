package com.yuanbao.crm.admin.sys.organization.web.controller;

/**
 * Created by gewen on 2017/1/21.
 */

import com.yuanbao.crm.admin.sys.organization.entity.Job;
import com.yuanbao.crm.common.Constants;
import com.yuanbao.crm.common.plugin.web.controller.BaseTreeableController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/admin/sys/organization/job")
public class JobController extends BaseTreeableController<Job, Long> {

    public JobController() {
        setResourceIdentity("sys:job");
    }

    @RequestMapping(value = "/changeStatus/{newStatus}")
    public String changeStatus(
            HttpServletRequest request,
            @PathVariable("newStatus") Boolean newStatus,
            @RequestParam("ids") Long[] ids,
            RedirectAttributes redirectAttributes
    ) {

        this.permissionList.assertHasUpdatePermission();

        for (Long id : ids) {
            Job job = baseService.findOne(id);
            job.setShow(newStatus);
            baseService.update(job);
        }
        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "操作成功！");

        return "redirect:" + request.getAttribute(Constants.BACK_URL);
    }

}