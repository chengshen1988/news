package com.news.hr.common.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ClassName HelloWorldJob
 * @Description: TODO
 * @Author daoan.guo@pcitc.com
 * @Date 2019/8/30
 * @Version V1.0
 **/
public class HelloWorldJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("定时任务执行：#"+jobExecutionContext.getFireTime());
    }
}
