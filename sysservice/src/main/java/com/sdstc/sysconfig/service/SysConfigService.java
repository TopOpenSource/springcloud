package com.sdstc.sysconfig.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "baseservice", fallback = SysConfigServiceHystric.class)
public interface SysConfigService {
	@RequestMapping(value = "/api/baseservice/sysconfig/sysconfig/getConfigAsInt")
	Integer getConfigAsInt(@RequestParam("type") String type,@RequestParam("key")  String key);
	@RequestMapping(value = "/api/baseservice/sysconfig/sysconfig/getConfigAsStr")
	String getConfigAsStr(@RequestParam("type")  String type,@RequestParam("key")  String key);
}
