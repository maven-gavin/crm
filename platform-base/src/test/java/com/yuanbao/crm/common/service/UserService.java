package com.yuanbao.crm.common.service;

import com.yuanbao.crm.common.entity.User;
import com.yuanbao.crm.common.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * Created by gewen on 2017/1/21.
 */
@DependsOn("userRepository")
@Service
public class UserService extends BaseService<User,Long> {

    @Autowired
    @Qualifier("userRepository")
    @Override
    public void setBaseRepository(BaseRepository<User, Long> baseRepository) {
        super.setBaseRepository(baseRepository);
    }
}
