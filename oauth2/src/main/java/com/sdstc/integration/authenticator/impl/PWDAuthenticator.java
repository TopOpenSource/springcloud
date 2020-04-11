package com.sdstc.integration.authenticator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdstc.integration.IntegrationAuthentication;
import com.sdstc.integration.authenticator.IntegrationAuthenticator;
import com.sdstc.model.UserSecurity;
import com.sdstc.pub.utils.StringUtils;
import com.sdstc.service.UserService;

/**
 * 用户名密码登录
 * @author cheng
 *
 */
@Component
public class PWDAuthenticator implements IntegrationAuthenticator{
	@Autowired
	private UserService userService;
	
	@Override
	public UserSecurity authenticate(IntegrationAuthentication integrationAuthentication) {
		return userService.getUserSecurity(integrationAuthentication.getUsername(), null,integrationAuthentication.getAuthType());
	}

	@Override
	public void prepare(IntegrationAuthentication integrationAuthentication) {
		
	}

	@Override
	public boolean support(IntegrationAuthentication integrationAuthentication) {
		 return IntegrationAuthentication.PWD.equals(integrationAuthentication.getAuthType())||StringUtils.isEmpty(integrationAuthentication.getAuthType());
	}

	@Override
	public void complete(IntegrationAuthentication integrationAuthentication) {
			
	}

}
