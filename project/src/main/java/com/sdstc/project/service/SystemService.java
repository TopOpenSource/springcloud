package com.sdstc.project.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "system",fallback = SystemServiceHystric.class)
public interface SystemService {
	@RequestMapping(value = "/api/system/test/testAdmin")
	String testAdmin();
}
