package com.sdstc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sdstc.config.filter.FilterExecuter;
import com.sdstc.pub.config.TokenExceptionEntryPoint;

/**
 * 资源安全配置
 * 
 * @author cheng
 *
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {
	@Autowired
	private FilterExecuter filterExecuter;

	@Autowired
	private TokenExceptionEntryPoint tokenExceptionEntryPoint;
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.authenticationEntryPoint(tokenExceptionEntryPoint).accessDeniedHandler(accessDeniedHandler);
	}

	/**
	 * 配置请求验证
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(filterExecuter, UsernamePasswordAuthenticationFilter.class)
		.requestMatchers().antMatchers("/api/**")
		.and()
		.authorizeRequests()
	    .antMatchers("/api/system/system/login","/api/system/system/refreshToken","/api/system/system/customRegister").permitAll()
	    .antMatchers("/api/**").authenticated();
	}

	/**
	 * 密码加密
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(14);
	}
}
