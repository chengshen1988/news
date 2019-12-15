package com.news.hr.common.service.impl;

import java.util.*;

import com.news.hr.common.bean.dto.TaskScheduler;
import com.news.hr.common.service.TaskSchedulerService;
import com.news.hr.framework.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CalendarIntervalScheduleBuilder;
import org.quartz.CronScheduleBuilder;
import org.quartz.DateBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CalendarIntervalTriggerImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

/**
 *
 * @ClassName: TaskSchedulerService
 * @Description: 任务调度服务类
 * @author daoan.guo@pcitc.com
 * @date 2018年2月22日 下午3:57:03
 *
 */
@Service
public class TaskSchedulerServiceImpl implements TaskSchedulerService {
	private static final Log logger = LogFactory.getLog(TaskSchedulerServiceImpl.class);

	@Autowired
	private Scheduler scheduler;


	@Override
	public void add(TaskScheduler taskScheduler) {
		Class<? extends Job> jobClass = taskScheduler.getJobClass();
		String jobName = taskScheduler.getJobName();
		String jobGroupName = StringUtils.isNullOrEmpty(taskScheduler.getJobGroupName()) ? Scheduler.DEFAULT_GROUP : taskScheduler.getJobGroupName();
		String triggerName = jobName;
		String triggerGroupName = StringUtils.isNullOrEmpty(taskScheduler.getJobGroupName()) ? Scheduler.DEFAULT_GROUP : taskScheduler.getJobGroupName();
		Date startTime = taskScheduler.getStartTime() == null ? new Date() : taskScheduler.getStartTime();
		Date endTime = taskScheduler.getEndTime();
		String description = StringUtils.isNullOrEmpty(taskScheduler.getDescription()) ? "" : taskScheduler.getDescription();

		try {
			JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).withDescription(description).build();
			if (taskScheduler.getCronExpression() != null && taskScheduler.getCronExpression().length() > 0) {
				Trigger trigger = TriggerBuilder
						.newTrigger().
								withIdentity(triggerName, triggerGroupName).
								startAt(startTime).
								endAt(endTime)
						.withSchedule(CronScheduleBuilder.cronSchedule(taskScheduler.getCronExpression()).withMisfireHandlingInstructionDoNothing()).build();
				scheduler.scheduleJob(jobDetail, trigger);
			} else {
				DateBuilder.IntervalUnit cycleUnit = taskScheduler.getIntervalUnit();
				Integer timeInterval = taskScheduler.getTimeInterval();
				Trigger trigger = TriggerBuilder
						.newTrigger()
						.withIdentity(triggerName, triggerGroupName)
						.startAt(startTime)
						.endAt(endTime)
						.withSchedule( CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withInterval(timeInterval, cycleUnit).withMisfireHandlingInstructionDoNothing()).build();
				scheduler.scheduleJob(jobDetail, trigger);
			}
		} catch (SchedulerException e) {
			throw new RuntimeException("添加任务失败", e);
		}

	}

	@Override
	public void modify(TaskScheduler taskScheduler) {
		String jobName = taskScheduler.getJobName();
		String jobGroupName = StringUtils.isNullOrEmpty(taskScheduler.getJobGroupName()) ? Scheduler.DEFAULT_GROUP : taskScheduler.getJobGroupName();
		String triggerName = jobName;
		String triggerGroupName = jobGroupName;
		Date startTime = taskScheduler.getStartTime() == null ? new Date() : taskScheduler.getStartTime();
		Date endTime = taskScheduler.getEndTime();

		HashSet<Trigger> triggerSet = new HashSet<>();
		if (taskScheduler.getCronExpression() != null && taskScheduler.getCronExpression().length() > 0) {
			Trigger trigger = TriggerBuilder
					.newTrigger().
							withIdentity(triggerName, triggerGroupName).
							startAt(startTime).
							endAt(endTime)
					.withSchedule(CronScheduleBuilder.cronSchedule(taskScheduler.getCronExpression()).withMisfireHandlingInstructionDoNothing()).build();
			triggerSet.add(trigger);
		} else {
			DateBuilder.IntervalUnit cycleUnit = taskScheduler.getIntervalUnit();
			Integer timeInterval = taskScheduler.getTimeInterval();
			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity(triggerName, triggerGroupName)
					.startAt(startTime)
					.endAt(endTime)
					.withSchedule( CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withInterval(timeInterval, cycleUnit).withMisfireHandlingInstructionDoNothing()).build();
			triggerSet.add(trigger);
		}
		JobKey jobKey = new JobKey(jobName, jobGroupName);
		JobDetail jobDetail = null;
		try {
			jobDetail = scheduler.getJobDetail(jobKey);
			scheduler.scheduleJob(jobDetail, triggerSet, true);
		} catch (Exception e) {
			throw new RuntimeException("修改任务失败", e);
		}
	}

	@Override
	public void remove(String jobName, String groupName) {
		groupName = StringUtils.isNullOrEmpty(groupName) ? Scheduler.DEFAULT_GROUP : groupName;
		try {
			JobKey jobKey = new JobKey(jobName, groupName);
			TriggerKey triggerKey = new TriggerKey(jobName, groupName);
			scheduler.pauseTrigger(triggerKey);
			scheduler.pauseJob(jobKey);
			scheduler.unscheduleJob(triggerKey);// 移除触发器
			scheduler.deleteJob(jobKey);// 删除任务
		} catch (Exception e) {
			throw new RuntimeException("删除任务失败", e);
		}
	}

	@Override
	public void remove(String jobName) {
		remove(jobName, Scheduler.DEFAULT_GROUP);
	}

	@Override
	public TaskScheduler selectOne(String jobName, String groupName) {
		groupName = StringUtils.isNullOrEmpty(groupName) ? Scheduler.DEFAULT_GROUP : groupName;

		TaskScheduler taskScheduler = new TaskScheduler();
		try {
			JobKey jobKey = new JobKey(jobName, groupName);
			JobDetail jobDetail = scheduler.getJobDetail(jobKey);
			taskScheduler.setJobName(jobName);
			taskScheduler.setJobGroupName(groupName);
			taskScheduler.setJobClass(jobDetail.getJobClass());
			taskScheduler.setDescription(jobDetail.getDescription());

			List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
			Trigger trigger = triggers.get(0);
			taskScheduler.setStartTime(trigger.getStartTime());
			taskScheduler.setEndTime(trigger.getEndTime());
			if (trigger.getClass().equals(CronTriggerImpl.class)) {
				CronTriggerImpl cronTriggerImpl = (CronTriggerImpl) trigger;
				taskScheduler.setCronExpression(cronTriggerImpl.getCronExpression());
			} else if (trigger.getClass().equals(CalendarIntervalTriggerImpl.class)) {
				CalendarIntervalTriggerImpl calendarIntervalTriggerImpl = (CalendarIntervalTriggerImpl) trigger;
				taskScheduler.setIntervalUnit(calendarIntervalTriggerImpl.getRepeatIntervalUnit());
				taskScheduler.setTimeInterval(calendarIntervalTriggerImpl.getRepeatInterval());
			}
		} catch (Exception e) {
			throw new RuntimeException("获取任务失败", e);
		}
		return taskScheduler;
	}

	@Override
	public TaskScheduler selectOne(String jobName) {
		return selectOne(jobName, Scheduler.DEFAULT_GROUP);
	}

	@Override
	public List<TaskScheduler> selectList() {
		List<TaskScheduler> taskSchedulers = new ArrayList<TaskScheduler>();
		GroupMatcher<JobKey> mathcher = GroupMatcher.anyJobGroup();
		try {
			Set<JobKey> jobKeys = scheduler.getJobKeys(mathcher);
			if(jobKeys != null){
				for(JobKey jobKey : jobKeys){
					TaskScheduler taskScheduler = new TaskScheduler();
					JobDetail jobDetail = scheduler.getJobDetail(jobKey);
					taskScheduler.setJobName(jobKey.getName());
					taskScheduler.setJobGroupName(jobKey.getGroup());
					taskScheduler.setJobClass(jobDetail.getJobClass());
					taskScheduler.setDescription(jobDetail.getDescription());


					List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
					Trigger trigger = triggers.get(0);

					taskScheduler.setStartTime(trigger.getStartTime());
					taskScheduler.setEndTime(trigger.getEndTime());
					if (trigger.getClass().equals(CronTriggerImpl.class)) {
						CronTriggerImpl cronTriggerImpl = (CronTriggerImpl) trigger;
						taskScheduler.setCronExpression(cronTriggerImpl.getCronExpression());
					} else if (trigger.getClass().equals(CalendarIntervalTriggerImpl.class)) {
						CalendarIntervalTriggerImpl calendarIntervalTriggerImpl = (CalendarIntervalTriggerImpl) trigger;
						taskScheduler.setIntervalUnit(calendarIntervalTriggerImpl.getRepeatIntervalUnit());
						taskScheduler.setTimeInterval(calendarIntervalTriggerImpl.getRepeatInterval());
					}
					taskScheduler.setState(scheduler.getTriggerState(trigger.getKey()).name());
					taskSchedulers.add(taskScheduler);
				}
			}
		} catch (SchedulerException e) {
			throw new RuntimeException("获取任务列表失败", e);
		}
		return taskSchedulers;
	}

	@Override
	public void pause(String jobName) {
		pause(jobName, Scheduler.DEFAULT_GROUP);
	}

	@Override
	public void pause(String jobName, String groupName) {
		groupName = StringUtils.isNullOrEmpty(groupName) ? Scheduler.DEFAULT_GROUP : groupName;
		try {
			TriggerKey triggerKey = new TriggerKey(jobName, groupName);
			scheduler.pauseTrigger(triggerKey);
			JobKey jobKey = new JobKey(jobName);
			scheduler.pauseJob(jobKey);
		} catch (Exception e) {
			throw new RuntimeException("暂停任务失败", e);
		}
	}

	@Override
	public void resume(String jobName) {
		resume(jobName, Scheduler.DEFAULT_GROUP);
	}

	@Override
	public void resume(String jobName, String groupName) {
		groupName = StringUtils.isNullOrEmpty(groupName) ? Scheduler.DEFAULT_GROUP : groupName;
		try {
			TriggerKey triggerKey = new TriggerKey(jobName, groupName);
			scheduler.resumeTrigger(triggerKey);
			JobKey jobKey = new JobKey(jobName);
			scheduler.resumeJob(jobKey);
		} catch (Exception e) {
			throw new RuntimeException("恢复任务失败", e);
		}
	}

	@Override
	public void executeJob(String jobName) {
		executeJob(jobName, Scheduler.DEFAULT_GROUP);
	}

	@Override
	public void executeJob(String jobName, String groupName) {
		groupName = StringUtils.isNullOrEmpty(groupName) ? Scheduler.DEFAULT_GROUP : groupName;
		JobKey jobKey = new JobKey(jobName, groupName);
		try {
			scheduler.triggerJob(jobKey);
		} catch (SchedulerException e) {
			throw new RuntimeException("任务执行失败", e);
		}
	}

	/**
	 * 验证是否存在
	 * @param jobName
	 * @param jobGroup
	 * @throws SchedulerException
	 */
	public boolean checkExists(String jobName, String jobGroup) throws SchedulerException{
		TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
		return scheduler.checkExists(triggerKey);
	}
}
