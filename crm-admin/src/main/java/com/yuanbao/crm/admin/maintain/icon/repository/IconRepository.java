package com.yuanbao.crm.admin.maintain.icon.repository;

import com.yuanbao.crm.admin.maintain.icon.entity.Icon;
import com.yuanbao.crm.common.repository.BaseRepository;

/**
 * Created by gewen on 2017/1/22.
 */
public interface IconRepository extends BaseRepository<Icon, Long> {
    Icon findByIdentity(String identity);
}
