package com.sdstc.system.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.oauth.service.Oauth2Service;
import com.sdstc.pub.dto.LoginUserInfo;


@RestController
@RequestMapping("/api/system/test")
public class TestController {
	@Autowired
	private  Oauth2Service oauth2Service;
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private Registration registration;
	
	private Set<String> hosts=new HashSet<String>();
	
	@RequestMapping("testAdmin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String testAdmin() {
		String host=registration.getHost();
		if(!hosts.contains(host)) {
			List<String> services=discoveryClient.getServices();
			for(String service:services) {
				List<ServiceInstance> instances=discoveryClient.getInstances(service);
				for(ServiceInstance instance:instances) {
					this.hosts.add(instance.getHost());
				}
			}
		}
		
		
		/**
		String serviceId=registration.getServiceId();
		String host=registration.getHost();
		int port=registration.getPort();
		
		List<ServiceInstance> instances=discoveryClient.getInstances(serviceId);
		**/
		LoginUserInfo userInfo=oauth2Service.userInfo();
		return "system-admin";
	}
	
	@RequestMapping("testUser")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String testUser() {
		return "system-user";
	}
}
