package com.sdstc.system.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/system/test")
public class TestController {
	
	@RequestMapping("testAdmin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String testAdmin() {
		return "system-admin";
	}
	
	@RequestMapping("testUser")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String testUser() {
		return "system-user";
	}
}
