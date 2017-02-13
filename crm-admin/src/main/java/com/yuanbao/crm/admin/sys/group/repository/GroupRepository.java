package com.yuanbao.crm.admin.sys.group.repository;

import com.yuanbao.crm.admin.sys.group.entity.Group;
import com.yuanbao.crm.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by gewen on 2017/1/21.
 */
public interface GroupRepository extends BaseRepository<Group, Long> {

    @Query("select id from Group where defaultGroup=true and show=true")
    List<Long> findDefaultGroupIds();

}
