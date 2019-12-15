package com.news.hr.common.bean.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.quartz.DateBuilder;
import org.quartz.Job;

import java.util.Date;

@Data
@ApiModel(value="Menu对象", description="")
public class TaskScheduler{
    private String jobName;
    private String jobGroupName;
    private String state;
    private Class<? extends Job> jobClass;
    private DateBuilder.IntervalUnit intervalUnit;
    private Integer timeInterval;
    private String cronExpression;
    private Date startTime;
    private Date endTime;
    private String description;
}