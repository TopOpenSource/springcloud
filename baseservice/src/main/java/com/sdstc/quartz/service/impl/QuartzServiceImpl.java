package com.sdstc.quartz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.quartz.dto.JobDto;
import com.sdstc.quartz.service.QuartzService;

/**
 * 
 * @author cheng
 *
 */
@Service("quartzService")
public class QuartzServiceImpl implements QuartzService {
	@Autowired
	private Scheduler scheduler;

	@Override
	public void addJob(JobDto dto) throws SchedulerException, ClassNotFoundException {
		Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(dto.getJobClazz());
		JobDetail job = JobBuilder.newJob(jobClass).withIdentity(dto.getJobName(),dto.getGroupName()).build();
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(dto.getCron());
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(dto.getTriggerName(),dto.getTriggerGroupName()).withSchedule(scheduleBuilder).build();
		scheduler.scheduleJob(job, trigger);
	}

	@Override
	public void pauseJob(JobDto dto) throws SchedulerException {
		scheduler.pauseJob(new JobKey(dto.getJobName(), dto.getGroupName()));
	}

	@Override
	public void resumeJob(JobDto dto) throws SchedulerException {
		scheduler.resumeJob(new JobKey(dto.getJobName(), dto.getGroupName()));
	}

	@Override
	public boolean isExist(JobDto dto) throws SchedulerException {
		return scheduler.checkExists(new JobKey(dto.getJobName(), dto.getGroupName()));
	}

	@Override
	public void deleteJob(JobDto dto) throws SchedulerException {
		scheduler.deleteJob(new JobKey(dto.getJobName(), dto.getGroupName()));
	}

	@Override
	public Integer getCurrentRuningJobs() throws SchedulerException {
		return scheduler.getCurrentlyExecutingJobs().size();
	}

	/**
	 * 实现思路
	 * 1.获取trigger groups
	 * 2.遍历 根据tiggergroup 获取triggerkey
	 * 3.遍历 根据triggerkey 获取 jobkey
	 * 4.根据 jobkey获取job
	 * 
	 */
	@Override
	public List<JobDto> getCurrentJobs() throws SchedulerException{
		List<JobDto> jobs=new ArrayList<JobDto>();
		List<String> triggerGroupNames=scheduler.getTriggerGroupNames();
		for(String triggerGroupName:triggerGroupNames) {
            GroupMatcher groupMatcher = GroupMatcher.groupEquals(triggerGroupName);
            Set<TriggerKey> triggerKeySet = scheduler.getTriggerKeys(groupMatcher);
            for (TriggerKey triggerKey : triggerKeySet) {
                CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                JobKey jobKey = trigger.getJobKey();
                JobDetailImpl jobDetail = (JobDetailImpl) scheduler.getJobDetail(jobKey);
                jobs.add(new JobDto(jobDetail.getName(), jobDetail.getGroup(),triggerKey.getName(),triggerKey.getGroup(), trigger.getCronExpression(), jobDetail.getJobClass().toString(),trigger.getNextFireTime()));
            }
		}
		return jobs;
	}

}
