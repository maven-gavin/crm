package com.yuanbao.crm.admin.sys.auth.repository;

import com.yuanbao.crm.admin.sys.auth.entity.Auth;
import com.yuanbao.crm.common.repository.BaseRepository;

import java.util.Set;

/**
 * Created by gewen on 2017/1/21.
 */
public interface AuthRepository extends BaseRepository<Auth, Long> {

    Auth findByUserId(Long userId);

    Auth findByGroupId(Long groupId);

    Auth findByOrganizationIdAndJobId(Long organizationId, Long jobId);

    ///////////委托给AuthRepositoryImpl实现
    public Set<Long> findRoleIds(Long userId, Set<Long> groupIds, Set<Long> organizationIds, Set<Long> jobIds, Set<Long[]> organizationJobIds);

}
