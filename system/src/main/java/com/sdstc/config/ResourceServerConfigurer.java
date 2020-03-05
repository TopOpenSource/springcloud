package com.sdstc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sdstc.config.securityFilter.validateCode.CustomAuthenticationFailureHandler;
import com.sdstc.config.securityFilter.validateCode.ValidateCodeFilter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {
	@Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    
	@Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	ValidateCodeFilter validateCodeFilter=new ValidateCodeFilter();
    	validateCodeFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);
    	
        http
                .addFilterBefore(validateCodeFilter,UsernamePasswordAuthenticationFilter.class)
                .requestMatchers().antMatchers("/api/**")
                .and()
                .authorizeRequests()
                .antMatchers("/api/system/system/login","/api/system/system/refreshToken").permitAll()
                .antMatchers("/api/**").authenticated();
    }
}
