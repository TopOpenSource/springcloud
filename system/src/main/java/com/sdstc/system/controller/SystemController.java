package com.sdstc.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.pub.dto.TokenDto;
import com.sdstc.system.model.UserInfo;
import com.sdstc.system.service.SystemService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/system/system")
@Log4j2
public class SystemController {
	@Autowired
	private SystemService systemService;

	@RequestMapping("login")
	public TokenDto login(UserInfo userInfo) {
		log.info(userInfo.getAccount()+":login");
		return systemService.getToken(userInfo);
	}

	@RequestMapping("refreshToken")
	public String refreshToken() {
		return "system-admin";
	}
}
