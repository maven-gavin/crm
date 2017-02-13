package com.yuanbao.crm.admin.maintain.keyvalue.repository;

import com.yuanbao.crm.admin.maintain.keyvalue.entity.KeyValue;
import com.yuanbao.crm.common.repository.BaseRepository;

/**
 * Created by gewen on 2017/1/22.
 */
public interface KeyValueRepository extends BaseRepository<KeyValue, Long> {

    KeyValue findByKey(String key);

}
