package com.news.hr.common.service;

import com.news.hr.common.bean.dto.TaskScheduler;

import java.util.List;

/**
 * @ClassName TaskSchedulerService
 * @Description: TODO
 * @Author daoan.guo@pcitc.com
 * @Date 2019/8/30
 * @Version V1.0
 **/
public interface TaskSchedulerService {
    /**
     * 添加任务
     *
     * @param taskScheduler
     */
    void add(TaskScheduler taskScheduler);

    void modify(TaskScheduler taskScheduler);

    void remove(String jobName, String groupName);

    void remove(String jobName);

    TaskScheduler selectOne(String jobName, String groupName);

    TaskScheduler selectOne(String jobName);

    List<TaskScheduler> selectList();

    void pause(String jobName);

    void pause(String jobName, String groupName);

    void resume(String jobName);

    void resume(String jobName, String groupName);

    void executeJob(String jobName);

    void executeJob(String jobName, String groupName);
}
