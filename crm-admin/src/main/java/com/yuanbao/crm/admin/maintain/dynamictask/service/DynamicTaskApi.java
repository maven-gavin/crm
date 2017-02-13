package com.yuanbao.crm.admin.maintain.dynamictask.service;

import com.yuanbao.crm.admin.maintain.dynamictask.entity.TaskDefinition;

/**
 * Created by gewen on 2017/1/22.
 */
public interface DynamicTaskApi {

    public void addTaskDefinition(TaskDefinition taskDefinition);
    public void updateTaskDefinition(TaskDefinition taskDefinition);
    public void deleteTaskDefinition(boolean forceTermination, Long... taskDefinitionIds);


    public void startTask(Long... taskDefinitionIds);
    public void stopTask(boolean forceTermination, Long... taskDefinitionId);


}
