package com.sdstc.config.filter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sdstc.pub.filter.FilterBuilder;

/**
 * 拦截器配置
 * 
 * @author cheng
 *
 */
@Configuration
public class FilterConfig {
	@Bean
	public FilterBuilder filterBuilder(ApplicationContext applicationContext) {
		FilterBuilder fb = new FilterBuilder(applicationContext);
        fb.addFilter(new AntPathRequestMatcher("/api/system/system/login", "POST"), "loginVCCheckFilter", "loginVCFailureHandler");
		return fb;
	}
}
