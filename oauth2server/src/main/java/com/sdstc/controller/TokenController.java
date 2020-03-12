package com.sdstc.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.model.UserSecurity;
import com.sdstc.pub.dto.LoginUserInfo;


@RestController
@RequestMapping("/api/oauth2")
public class TokenController {
	@Autowired
	ConsumerTokenServices consumerTokenServices;

	@Value("${oauth2.signingKey}")
	private  String signingKey;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	private Map<String,Integer> hosts=new HashMap<String,Integer>();
	
	@RequestMapping("admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String admin() {
		return "admin";
	}

	@RequestMapping("user")
	public Principal user(Principal principal) {
		return principal;
	}
	
	@RequestMapping("userInfo")
	public LoginUserInfo userInfo(Principal principal) {
		OAuth2Authentication oauth2=(OAuth2Authentication) principal;
		UserSecurity user=(UserSecurity) oauth2.getUserAuthentication().getPrincipal();
		LoginUserInfo userInfo=new LoginUserInfo();
		userInfo.setCustomerId(user.getCustomerId());
		userInfo.setUserAccount(user.getUsername());
		for(GrantedAuthority auth:user.getAuthorities()) {
			userInfo.addAuth(auth.getAuthority());
		}
		return userInfo;
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
	
	@RequestMapping("getWorkerId")
	public Long getWorkId(String host) {
		if(!hosts.containsKey(host)) {
			hosts.clear();
			int i=0;
			List<String> services=discoveryClient.getServices();
			for(String service:services) {
				List<ServiceInstance> instances=discoveryClient.getInstances(service);
				for(ServiceInstance instance:instances) {
					String hostName=instance.getHost();
					if(!hosts.containsKey(hostName)) {
						hosts.put(hostName, i++);
					}
				}
			}
		}
		return hosts.get(host).longValue();
	}

}
