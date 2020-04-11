package com.sdstc.email.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.email.dto.EmailDto;
import com.sdstc.email.service.EmailService;
import com.sdstc.pub.dto.ResultDto;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/baseservice/email/email")
@Log4j2
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("sendEmail")
	public ResultDto sendEmail(EmailDto dto) throws ClassNotFoundException, SchedulerException {
		emailService.send(dto);
		return new ResultDto(1, null);
	}
}
