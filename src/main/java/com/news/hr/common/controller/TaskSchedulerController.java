package com.news.hr.common.controller;

import com.news.hr.common.bean.dto.TaskScheduler;
import com.news.hr.common.service.TaskSchedulerService;
import com.news.hr.framework.model.ReturnModel;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName QuartzController
 * @Description: TODO
 * @Author daoan.guo@pcitc.com
 * @Date 2019/8/30
 * @Version V1.0
 **/
@RestController
@Api(value = "通用-定时任务", tags = {"通用-定时任务"})
@RequestMapping("taskScheduler")
public class TaskSchedulerController {
    
    @Resource
    private TaskSchedulerService schedulerService;

    @RequestMapping(value = "add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel add(TaskScheduler taskScheduler) {
        schedulerService.add(taskScheduler);
        return ReturnModel.newSuccessInstance(taskScheduler.getJobName());
    }

    @RequestMapping(value = "remove", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel remove(String jobName) {
        schedulerService.remove(jobName);
        return ReturnModel.newSuccessInstance(jobName);
    }

    @RequestMapping(value = "modify", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel modify(TaskScheduler taskScheduler) {
        schedulerService.modify(taskScheduler);
        return ReturnModel.newSuccessInstance(taskScheduler.getJobName());
    }

    @RequestMapping(value = "pause", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel pause(String jobName) {
        schedulerService.pause(jobName);
        return ReturnModel.newSuccessInstance(jobName);
    }

    @RequestMapping(value = "resume", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel resume(String jobName) {
        schedulerService.resume(jobName);
        return ReturnModel.newSuccessInstance(jobName);
    }

    @RequestMapping(value = "executeJob", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel executeJob(String jobName) {
        schedulerService.executeJob(jobName);
        return ReturnModel.newSuccessInstance(jobName);
    }

    @RequestMapping(value = "selectOne", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectOne(String jobName) {
        TaskScheduler taskScheduler = schedulerService.selectOne(jobName);
        return ReturnModel.newSuccessInstance(taskScheduler);
    }

    @RequestMapping(value = "selectList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectList() {
        List<TaskScheduler> taskSchedulers = schedulerService.selectList();
        return ReturnModel.newSuccessInstance(taskSchedulers);
    }

}
