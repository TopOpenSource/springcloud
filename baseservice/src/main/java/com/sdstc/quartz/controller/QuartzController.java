package com.sdstc.quartz.controller;

import java.util.List;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.quartz.dto.JobDto;
import com.sdstc.quartz.service.QuartzService;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author cheng
 *
 */
@RestController
@RequestMapping("/api/baseservice/quartz/quartz")
@Log4j2
public class QuartzController {
	@Autowired
	private QuartzService quartzService;

	@RequestMapping("addJob")
	public ResultDto addJob(JobDto dto) throws ClassNotFoundException, SchedulerException {
		log.info("add job"+JSONObject.toJSONString(dto));
		quartzService.addJob(dto);
		return new ResultDto(1, null);
	}
	
	@RequestMapping("deleteJob")
	public ResultDto deleteJob(JobDto dto) throws SchedulerException {
		quartzService.deleteJob(dto);
		return new ResultDto(1, null);
	}
	
	@RequestMapping("pauseJob")
	public ResultDto pauseJob(JobDto dto) throws SchedulerException {
		quartzService.pauseJob(dto);
		return new ResultDto(1, null);
	}
	
	@RequestMapping("resumeJob")
	public ResultDto resumeJob(JobDto dto) throws SchedulerException {
		quartzService.resumeJob(dto);
		return new ResultDto(1, null);
	}
	
	@RequestMapping("isExist")
	public Boolean isExist(JobDto dto) throws SchedulerException {
		return quartzService.isExist(dto);
	}
	
	@RequestMapping("getCurrentJobs")
	public List<JobDto> getCurrentJobs() throws SchedulerException {
		return quartzService.getCurrentJobs();
	}
	
}
