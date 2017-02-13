package com.yuanbao.crm.common.web.controller;

import com.yuanbao.crm.common.Constants;
import com.yuanbao.crm.common.web.upload.FileUploadUtils;
import com.yuanbao.crm.common.web.utils.DownloadUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;

/**
 * Created by gewen on 2017/1/20.
 */
@Controller
public class DownloadController {
    /**
     * 下载内容前边显示的前缀
     */
    private String prefixFilename = "[CRM下载文件]";

    @RequestMapping(value = "/download")
    public String download(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value = "filename") String filename) throws Exception{
        filename = filename.replace("/", "\\");

        if (StringUtils.isEmpty(filename) || filename.contains("\\.\\.")) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("您下载的文件不存在！");
            return null;
        }
        filename = URLDecoder.decode(filename, Constants.ENCODING);

        String filePath = FileUploadUtils.extractUploadDir(request) + "/" + filename;

        DownloadUtils.download(request, response, filePath, prefixFilename + filename);

        return null;
    }
}
