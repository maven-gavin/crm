package com.yuanbao.crm.admin.sys.permission.entity;

import com.google.common.collect.Lists;
import com.yuanbao.crm.common.entity.BaseEntity;
import com.yuanbao.crm.common.repository.support.annotation.EnableQueryCache;
import com.yuanbao.crm.common.utils.ReflectUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gewen on 2017/1/21.
 */
@Entity
@Table(name = "sys_role")
@EnableQueryCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends BaseEntity<Long> {
    /**
     * 前端显示名称
     */
    private String name;
    /**
     * 系统中验证时使用的角色标识
     */
    private String role;

    /**
     * 详细描述
     */
    private String description;

    /**
     * 角色，资源，权限关联表
     */
    @OneToMany(mappedBy = "role",targetEntity = RoleResourcePermission.class,fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,orphanRemoval = true)
    @Fetch(FetchMode.SELECT)
    @Basic(optional = true,fetch = FetchType.EAGER)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OrderBy
    private List<RoleResourcePermission> resourcePermissions;

    /**
     * 是否显示 也表示是否可用 为了统一 都使用这个
     */
    @Column(name = "is_show")
    private Boolean show = Boolean.FALSE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RoleResourcePermission> getResourcePermissions() {
        if (resourcePermissions == null) {
            resourcePermissions = Lists.newArrayList();
        }
        return resourcePermissions;
    }

    public void setResourcePermissions(List<RoleResourcePermission> resourcePermissions) {
        this.resourcePermissions = resourcePermissions;
    }

    public void addResourcePermission(RoleResourcePermission roleResourcePermission) {
        roleResourcePermission.setRole(this);
        getResourcePermissions().add(roleResourcePermission);
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
