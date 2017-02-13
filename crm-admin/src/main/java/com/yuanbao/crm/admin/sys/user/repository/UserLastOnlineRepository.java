package com.yuanbao.crm.admin.sys.user.repository;

import com.yuanbao.crm.admin.sys.user.entity.UserLastOnline;
import com.yuanbao.crm.common.repository.BaseRepository;

/**
 * Created by gewen on 2017/1/21.
 */
public interface UserLastOnlineRepository extends BaseRepository<UserLastOnline,Long> {
    UserLastOnline findByUserId(Long userId);
}
