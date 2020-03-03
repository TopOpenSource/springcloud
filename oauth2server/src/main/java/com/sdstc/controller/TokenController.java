package com.sdstc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class TokenController {
	@Autowired
	ConsumerTokenServices consumerTokenServices;

	@RequestMapping("admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String admin() {
		return "admin";
	}
	@RequestMapping("user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String user() {
		return "user";
	}
	
	@GetMapping("/removeToken")
	public Boolean removeToken(Authentication authentication) {
		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
		return consumerTokenServices.revokeToken(details.getTokenValue());
	}
	
	@GetMapping("/changeAuth")
	public String changeAuth() {
		
		return null;
	}
}



