package com.sdstc.quartz.service;

import java.util.List;

import org.quartz.SchedulerException;

import com.sdstc.quartz.dto.JobDto;

/**
 * 
 * @author cheng
 *
 */
public interface QuartzService {

	/**
	 * 新增任务
	 * 
	 * @param jobName
	 * @param groupName
	 * @param triggerName
	 * @param cron
	 * @param jobClazz
	 * @throws SchedulerException
	 */
	void addJob(JobDto dto) throws SchedulerException, ClassNotFoundException;

	/**
	 * 删除任务
	 * 
	 * @param jobName
	 * @param groupName
	 * @throws SchedulerException
	 */
	void deleteJob(JobDto dto) throws SchedulerException;

	/**
	 * 暂停
	 * @param jobName
	 * @param groupName
	 * @throws SchedulerException
	 */
	void pauseJob(JobDto dto) throws SchedulerException;

	/**
	 * 重启任务
	 * @param jobName
	 * @param groupName
	 * @throws SchedulerException
	 */
	void resumeJob(JobDto dto) throws SchedulerException;

	/**
	 * 检测任务是否存在
	 * @param jobName
	 * @param groupName
	 * @return
	 * @throws SchedulerException
	 */
	boolean isExist(JobDto dto) throws SchedulerException;

	Integer getCurrentRuningJobs() throws SchedulerException;
	
	List<JobDto> getCurrentJobs() throws SchedulerException;
}
