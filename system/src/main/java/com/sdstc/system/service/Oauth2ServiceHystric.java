package com.sdstc.system.service;

import org.springframework.stereotype.Component;
import com.sdstc.pub.dto.LoginUserInfo;

@Component
public class Oauth2ServiceHystric implements Oauth2Service {

	@Override
	public LoginUserInfo userInfo() {
		return null;
	}


}
