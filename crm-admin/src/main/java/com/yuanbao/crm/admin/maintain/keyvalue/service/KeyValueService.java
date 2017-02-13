package com.yuanbao.crm.admin.maintain.keyvalue.service;

import com.yuanbao.crm.admin.maintain.keyvalue.entity.KeyValue;
import com.yuanbao.crm.admin.maintain.keyvalue.repository.KeyValueRepository;
import com.yuanbao.crm.common.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * Created by gewen on 2017/1/22.
 */
@Service
public class KeyValueService extends BaseService<KeyValue, Long> {

    private KeyValueRepository getKeyValueRepository() {
        return (KeyValueRepository) baseRepository;
    }


    public KeyValue findByKey(String key) {
        return getKeyValueRepository().findByKey(key);
    }

}