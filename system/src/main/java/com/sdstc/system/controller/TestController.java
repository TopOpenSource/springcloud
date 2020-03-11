package com.sdstc.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.oauth.service.Oauth2Service;
import com.sdstc.pub.dto.LoginUserInfo;


@RestController
@RequestMapping("/api/system/test")
public class TestController {
	@Autowired
	private  Oauth2Service oauth2Service;
	
	@RequestMapping("testAdmin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String testAdmin() {
		LoginUserInfo userInfo=oauth2Service.userInfo();
		return "system-admin";
	}
	
	@RequestMapping("testUser")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String testUser() {
		return "system-user";
	}
}
