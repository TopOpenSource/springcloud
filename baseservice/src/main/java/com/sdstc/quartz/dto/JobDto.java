package com.sdstc.quartz.dto;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @author cheng
 *
 */
@Data
public class JobDto {
	/**
	 * job名称
	 */
	private String jobName;
	/**
	 * job组名
	 */
	private String groupName;
	/**
	 * 触发器名称
	 */
	private String triggerName;
	/**
	 *触发器组名
	 */
	private String triggerGroupName;
	/**
	 * 触发时间表达式
	 */
	private String cron;
	/**
	 * 作业执行类
	 */
	private String jobClazz;
	
	/**
	 * 下次触发时间
	 */
	private Date nextFireTime;
	
	public JobDto() {
		
	}
	
	public JobDto(String jobName,String groupName,String triggerName,String triggerGroupName,String cron,String jobClazz, Date nextFireTime) {
		this.jobName=jobName;
		this.groupName=groupName;
		this.triggerName=triggerName;
		this.triggerGroupName=triggerGroupName;
		this.cron=cron;
		this.jobClazz=jobClazz;
		this.nextFireTime=nextFireTime;
		
	}
}
