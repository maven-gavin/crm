<%@ tag import="com.google.common.collect.Lists" %>
<%@ tag import="com.yuanbao.crm.common.utils.SpringUtils" %>
<%@ tag import="com.yuanbao.crm.admin.sys.app.entity.App" %>
<%@ tag import="com.yuanbao.crm.admin.sys.app.service.AppService" %>
<%@ tag import="java.util.List" %>
<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="id" type="java.lang.Long" required="true" description="当前要展示的应用的名字" %>
<%!private AppService appService;%>
<%

    if(appService == null) {
        appService = SpringUtils.getBean(AppService.class);
    }

    App app = appService.findOne(id);

    if(app == null ) {
        out.write("<span class='label label-important'>删除的数据，请修改</span>");
        return;
    }

    List<String> names = Lists.newArrayList();

    names.add(app.getName());

    StringBuilder s = new StringBuilder();
    s.append(String.format("<a class='btn btn-link no-padding' href='%s/admin/sys/app/%d'>", request.getContextPath(), id));

    for(int l = names.size() - 1, i = l; i >= 0; i--) {
        if(i != l) {
            s.append(" &gt; ");
        }
        s.append(names.get(i));
    }

    s.append("</a>");
    out.write(s.toString());

%>
