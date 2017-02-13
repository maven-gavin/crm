package com.yuanbao.crm.admin.sys.permission.entity;

import com.google.common.collect.Sets;
import com.yuanbao.crm.common.entity.BaseEntity;
import com.yuanbao.crm.common.repository.hibernate.type.CollectionToStringUserType;
import com.yuanbao.crm.common.repository.support.annotation.EnableQueryCache;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by gewen on 2017/1/21.
 */
@TypeDef(
        name = "SetToStringUserType",
        typeClass = CollectionToStringUserType.class,
        parameters = {
                @Parameter(name="separate",value = ","),
                @Parameter(name = "collectionType", value = "java.util.HashSet"),
                @Parameter(name = "elementType", value = "java.lang.Long")
        }
)
@Entity
@EnableQueryCache
@Table(name = "sys_role_resource_permission")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RoleResourcePermission extends BaseEntity<Long> {

    /**
     * 角色id
     */
    @ManyToOne(optional = true,fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Role role;

    /**
     * 资源id
     */
    @Column(name = "resource_id")
    private Long resourceId;

    /**
     * 权限id列表
     * 数据库通过字符串存储 逗号分隔
     */
    @Column(name = "permission_ids")
    @Type(type = "SetToStringUserType")
    private Set<Long> permissionIds;

    public RoleResourcePermission() {
    }

    public RoleResourcePermission(Long id) {
        setId(id);
    }

    public RoleResourcePermission(Long resourceId, Set<Long> permissionIds) {
        this.resourceId = resourceId;
        this.permissionIds = permissionIds;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Set<Long> getPermissionIds() {
        if (permissionIds == null) {
            permissionIds = Sets.newHashSet();
        }
        return permissionIds;
    }

    public void setPermissionIds(Set<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }

    @Override
    public String toString() {
        return "RoleResourcePermission{id=" + this.getId() +
                ",roleId=" + (role != null ? role.getId() : "null") +
                ", resourceId=" + resourceId +
                ", permissionIds=" + permissionIds +
                '}';
    }
}
