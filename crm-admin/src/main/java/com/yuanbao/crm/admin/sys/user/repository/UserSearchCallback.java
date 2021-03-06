package com.yuanbao.crm.admin.sys.user.repository;

import com.yuanbao.crm.admin.sys.organization.entity.Job;
import com.yuanbao.crm.admin.sys.organization.entity.Organization;
import com.yuanbao.crm.common.entity.search.Searchable;
import com.yuanbao.crm.common.repository.callback.DefaultSearchCallback;

import javax.persistence.Query;

/**
 * Created by gewen on 2017/1/21.
 */
public class UserSearchCallback extends DefaultSearchCallback {
    public UserSearchCallback() {
        super("x");
    }

    @Override
    public void prepareQL(StringBuilder ql, Searchable search) {
        super.prepareQL(ql, search);

        boolean hasOrganization = search.containsSearchKey("organization");
        boolean hasJob = search.containsSearchKey("job");
        if (hasOrganization || hasJob) {
            ql.append(" and exists(select 1 from UserOrganizationJob oj");
            if (hasOrganization) {
                ql.append(" left join oj.organization o ");

            }
            if (hasJob) {
                ql.append(" left join oj.job j ");

            }

            ql.append(" where oj.user=x ");
            if (hasOrganization) {
                ql.append(" and (o.id=:organizationId or o.parentIds like :organizationParentIds)");
            }
            if (hasJob) {
                ql.append(" and (j.id=:jobId or j.parentIds like :jobParentIds)");
            }

            ql.append(")");
        }

    }

    @Override
    public void setValues(Query query, Searchable search) {
        super.setValues(query, search);

        if (search.containsSearchKey("organization")) {
            Organization organization = (Organization) search.getValue("organization");
            query.setParameter("organizationId", organization.getId());
            query.setParameter("organizationParentIds", organization.makeSelfAsNewParentIds() + "%");
        }

        if (search.containsSearchKey("job")) {
            Job job = (Job) search.getValue("job");
            query.setParameter("jobId", job.getId());
            query.setParameter("jobParentIds", job.makeSelfAsNewParentIds() + "%");
        }
    }
}
