package com.sdstc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
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

	@Value("${oauth2.signingKey}")
	private  String signingKey;
	
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
	public Boolean removeToken(OAuth2Authentication authentication) {
		//删除redis current
		UsernamePasswordAuthenticationToken userAuth=(UsernamePasswordAuthenticationToken) authentication.getUserAuthentication();
		User user=(User) userAuth.getPrincipal();
		System.out.println(user.getUsername());
		
		//删除token
		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
		consumerTokenServices.revokeToken(details.getTokenValue());
		
		return true;
	}

	@GetMapping("/changeAuth")
	public String changeAuth() {

		return null;
	}
}
