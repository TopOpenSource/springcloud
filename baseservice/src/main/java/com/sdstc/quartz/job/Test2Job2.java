package com.sdstc.quartz.job;


import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @DisallowConcurrentExecution 防止分布式环境下的并行执行
 * @author cheng
 *
 */
@DisallowConcurrentExecution
public class Test2Job2 extends QuartzJobBean{
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
	}
}
