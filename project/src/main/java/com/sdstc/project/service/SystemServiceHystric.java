package com.sdstc.project.service;

import org.springframework.stereotype.Component;

@Component
public class SystemServiceHystric implements SystemService {

	@Override
	public String testAdmin() {
		return "error-admin-";
	}

	@Override
	public String testUser() {
		return "error-user-";
	}


}
