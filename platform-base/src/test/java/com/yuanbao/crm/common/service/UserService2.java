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
@DependsOn("userRepository2")
@Service
public class UserService2 extends UserService {

    @Autowired
    @Qualifier("userRepository2")
    @Override
    public void setBaseRepository(BaseRepository<User, Long> baseRepository) {
        super.setBaseRepository(baseRepository);
    }
}
