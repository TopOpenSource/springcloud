package com.sdstc.email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.sdstc.email.dto.EmailDto;
import com.sdstc.email.service.EmailService;
import com.sdstc.pub.constant.SysConfigConstant;
import com.sdstc.sysconfig.service.SysConfigService;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
	@Autowired
	private SysConfigService sysConfigService;
	
	@Override
	public void send(EmailDto dto) {
		JavaMailSenderImpl mailSender=this.getMailSender();
		SimpleMailMessage mainMessage = new SimpleMailMessage();
		mainMessage.setTo(dto.getToEmail());
		mainMessage.setSubject(dto.getSubject());
		mainMessage.setText(dto.getText());
		mainMessage.setFrom(sysConfigService.getConfigAsStr(SysConfigConstant.EMAIL, "USERNAME"));
		mailSender.send(mainMessage);
	}
	
	private  JavaMailSenderImpl  getMailSender() {
		JavaMailSenderImpl  mailSender=new JavaMailSenderImpl();
		mailSender.setDefaultEncoding("UTF-8");
		mailSender.setHost(sysConfigService.getConfigAsStr(SysConfigConstant.EMAIL, "HOST"));
		mailSender.setPort(sysConfigService.getConfigAsInt(SysConfigConstant.EMAIL, "PORT"));
		mailSender.setUsername(sysConfigService.getConfigAsStr(SysConfigConstant.EMAIL, "USERNAME"));
		mailSender.setPassword(sysConfigService.getConfigAsStr(SysConfigConstant.EMAIL, "PASSWORD"));
		return mailSender;
	}

}
