package com.yuanbao.crm.admin.maintain.dynamictask.web.controller;

import com.yuanbao.crm.admin.maintain.dynamictask.entity.TaskDefinition;
import com.yuanbao.crm.admin.maintain.dynamictask.service.DynamicTaskApi;
import com.yuanbao.crm.common.Constants;
import com.yuanbao.crm.common.web.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-28 下午4:29
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "/admin/maintain/dynamicTask")
public class DynamicTaskController extends BaseCRUDController<TaskDefinition, Long> {

    @Autowired
    private DynamicTaskApi dynamicTaskApi;

    @Override
    public String create(Model model, @Valid @ModelAttribute("m") TaskDefinition m, BindingResult result, RedirectAttributes redirectAttributes) {
        if (permissionList != null) {
            this.permissionList.assertHasCreatePermission();
        }

        if (hasError(m, result)) {
            return showCreateForm(model);
        }
        dynamicTaskApi.addTaskDefinition(m);
        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "新增成功");
        return redirectToUrl(null);
    }

    @Override
    public String update(Model model, @Valid @ModelAttribute("m") TaskDefinition m, BindingResult result, @RequestParam(value = Constants.BACK_URL, required = false) String backURL, RedirectAttributes redirectAttributes) {
        if (permissionList != null) {
            this.permissionList.assertHasUpdatePermission();
        }

        if (hasError(m, result)) {
            return showUpdateForm(model,m);
        }
        dynamicTaskApi.updateTaskDefinition(m);
        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "修改成功");
        return redirectToUrl(backURL);
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
    public String delete(
            @RequestParam(value = "forceTermination") boolean forceTermination,
            @PathVariable("id") TaskDefinition m,
            @RequestParam(value = Constants.BACK_URL, required = false) String backURL,
            RedirectAttributes redirectAttributes) {
        if (permissionList != null) {
            this.permissionList.assertHasDeletePermission();
        }

        dynamicTaskApi.deleteTaskDefinition(forceTermination, m.getId());
        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "删除成功");
        return redirectToUrl(backURL);
    }

    @RequestMapping(value = "batch/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteInBatch(
            @RequestParam(value = "forceTermination") boolean forceTermination,
            @RequestParam(value = "ids", required = false) Long[] ids,
            @RequestParam(value = Constants.BACK_URL, required = false) String backURL,
            RedirectAttributes redirectAttributes) {
        if (permissionList != null) {
            this.permissionList.assertHasDeletePermission();
        }

        dynamicTaskApi.deleteTaskDefinition(forceTermination, ids);

        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "删除成功");
        return redirectToUrl(backURL);
    }


    @RequestMapping("/start")
    public String startTask(
            @RequestParam(value = "ids", required = false) Long[] ids,
            @RequestParam(value = Constants.BACK_URL, required = false) String backURL,
            RedirectAttributes redirectAttributes) {
        if (permissionList != null) {
            this.permissionList.assertHasDeletePermission();
        }

        dynamicTaskApi.startTask(ids);

        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "启动任务成功");
        return redirectToUrl(backURL);
    }

    @RequestMapping("/stop")
    public String stopTask(
            @RequestParam(value = "forceTermination") boolean forceTermination,
            @RequestParam(value = "ids", required = false) Long[] ids,
            @RequestParam(value = Constants.BACK_URL, required = false) String backURL,
            RedirectAttributes redirectAttributes) {
        if (permissionList != null) {
            this.permissionList.assertHasDeletePermission();
        }

        dynamicTaskApi.stopTask(forceTermination, ids);

        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "停止任务成功");
        return redirectToUrl(backURL);
    }


    @RequestMapping(value = "{id}/delete/discard", method = RequestMethod.POST)
    @Override
    public String delete(@PathVariable("id") TaskDefinition taskDefinition, @RequestParam(value = Constants.BACK_URL, required = false) String backURL, RedirectAttributes redirectAttributes) {
        throw new RuntimeException("discard method");
    }

    @RequestMapping(value = "batch/delete/discard", method = {RequestMethod.GET, RequestMethod.POST})
    @Override
    public String deleteInBatch(@RequestParam(value = "ids", required = false) Long[] longs, @RequestParam(value = Constants.BACK_URL, required = false) String backURL, RedirectAttributes redirectAttributes) {
        throw new RuntimeException("discard method");
    }
}