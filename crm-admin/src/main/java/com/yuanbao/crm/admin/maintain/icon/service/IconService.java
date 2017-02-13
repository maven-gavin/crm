package com.yuanbao.crm.admin.maintain.icon.service;

import com.yuanbao.crm.admin.maintain.icon.entity.Icon;
import com.yuanbao.crm.admin.maintain.icon.repository.IconRepository;
import com.yuanbao.crm.common.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * Created by gewen on 2017/1/22.
 */
@Service
public class IconService extends BaseService<Icon, Long> {

    private IconRepository getIconRepository() {
        return (IconRepository) baseRepository;
    }

    public Icon findByIdentity(String identity) {
        return getIconRepository().findByIdentity(identity);
    }
}