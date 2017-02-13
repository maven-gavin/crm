package com.yuanbao.crm.admin.sys.group.task;

/**
 * Created by gewen on 2017/1/21.
 */
import com.yuanbao.crm.admin.sys.group.repository.GroupRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 清理无关联的关系
 * 1、Group-GroupRelation
 * 2、GroupRelation-User
 * 3、GroupRelation-Organization
 * 4、GroupRelation-Job
 * <p/>
 * <p>User: Zhang Kaitao
 * <p>Date: 13-5-13 下午5:35
 * <p>Version: 1.0
 */
@Service
public class GroupClearRelationTask {

    @Autowired
    private GroupRelationRepository groupRelationRepository;

    /**
     * 清除删除的分组对应的关系
     */
    public void clearDeletedGroupRelation() {
        groupRelationRepository.clearDeletedGroupRelation();
    }

}
