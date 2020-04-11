package com.sdstc.sysconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.sysconfig.service.SysConfigService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/baseservice/sysconfig/sysconfig")
@Log4j2
public class SysConfigController {
	@Autowired
    private SysConfigService sysConfigService;
	
	@RequestMapping("getConfigAsInt")
	public Integer getConfigAsInt(String type,String key) {
		return sysConfigService.getConfigAsInt(type, key);
	}
	
	@RequestMapping("getConfigAsStr")
	public String getConfigAsStr(String type,String key) {
		return sysConfigService.getConfigAsStr(type, key);
	}
	
}
