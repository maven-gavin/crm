package com.yuanbao.crm.admin.sys.permission.repository;

import com.yuanbao.crm.admin.sys.permission.entity.Role;
import com.yuanbao.crm.admin.sys.permission.entity.RoleResourcePermission;
import com.yuanbao.crm.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by gewen on 2017/1/21.
 */
public interface RoleRepository extends BaseRepository<Role,Long> {

    @Query("from RoleResourcePermission where role=?1 and resourceId=?2")
    RoleResourcePermission findRoleResourcePermission(Role role, Long resourceId);
}
