package com.sdstc.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.sdstc.pub.filter.FilterBuilder;

/**
 * 拦截器执行
 * @author cheng
 *
 */
@Component("filterExecuter")
public class FilterExecuter extends OncePerRequestFilter {
	@Autowired
	private FilterBuilder  filterBuilder;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if(filterBuilder.checkReq(request, response)) {
			filterChain.doFilter(request, response);
		}
	}
}
