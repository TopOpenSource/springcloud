package com.sdstc.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sdstc.integration.IntegrationAuthentication;
import com.sdstc.integration.IntegrationAuthenticationContext;
import com.sdstc.integration.authenticator.IntegrationAuthenticator;
import com.sdstc.model.UserSecurity;
import com.sdstc.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service("userDetailService")
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
	private List<IntegrationAuthenticator> authenticators;

    @Autowired(required = false)
    public void setIntegrationAuthenticators(List<IntegrationAuthenticator> authenticators) {
        this.authenticators = authenticators;
    }
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		IntegrationAuthentication integrationAuthentication = IntegrationAuthenticationContext.get();
        
        if (integrationAuthentication == null) {
            integrationAuthentication = new IntegrationAuthentication();
        }
        integrationAuthentication.setUsername(username);
        UserSecurity user = this.authenticate(integrationAuthentication);
        return user;
	}
	
	private UserSecurity authenticate(IntegrationAuthentication integrationAuthentication) {
        if (this.authenticators != null) {
            for (IntegrationAuthenticator authenticator : authenticators) {
                if (authenticator.support(integrationAuthentication)) {
                    return authenticator.authenticate(integrationAuthentication);
                }
            }
        }
        return null;
    }
	
}
