package com.sdstc.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.oauth.service.Oauth2Service;
import com.sdstc.project.service.SystemService;
import com.sdstc.pub.dto.LoginUserInfo;

@RestController
@RequestMapping("/api/project/test")
public class TestController {
	@Autowired
	private SystemService systemService;
	@Autowired
	private  Oauth2Service oauth2Service;
	
    @RequestMapping("testAdmin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String testAdmin() {
    	LoginUserInfo userInfo=oauth2Service.userInfo();
    	/**
    	SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        System.out.println(details.getTokenValue());
        return systemService.testAdmin()+"-admin";
        **/
    	return null;
    }
    
    @RequestMapping("testUser")
	@PreAuthorize("hasRole('ROLE_USER')")
    public String testUser() {
    	SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        System.out.println(details.getTokenValue());
        return systemService.testUser()+"-user";
    }
}
