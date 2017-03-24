package com.yuanbao.crm.common.repository;

import com.yuanbao.crm.common.entity.BaseInfo;
import com.yuanbao.crm.common.entity.SchoolInfo;
import com.yuanbao.crm.common.entity.User;
import com.yuanbao.crm.common.entity.search.Searchable;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by gewen on 2017/1/20.
 */
public interface UserRepository2 extends BaseRepository<User, Long> {


    ////////////////////////////////////////////////////
    /////////以下实现都委托给UserRepository2Impl///////
    ////////////////////////////////////////////////////

    public BaseInfo findBaseInfoByUserId(Long userId);

    public List<SchoolInfo> findAllSchoolTypeByUserId(Long userId);

    public Page<User> findAllByDefault(final Searchable searchable);

    public long countAllByDefault(final Searchable searchable);

    public long countAllByCustom(final Searchable searchable);

    public Page<User> findAllByCustom(final Searchable searchable);

}
