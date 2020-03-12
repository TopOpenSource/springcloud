package com.sdstc.oauth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sdstc.pub.dto.LoginUserInfo;

@FeignClient(name = "oauth2", fallback = Oauth2ServiceHystric.class)
public interface Oauth2Service {

	@RequestMapping(value = "/api/oauth2/userInfo")
	LoginUserInfo userInfo();
	@RequestMapping(value = "/api/oauth2/getWorkerId")
	Long getWorkerId(@RequestParam("host") String host);
}
