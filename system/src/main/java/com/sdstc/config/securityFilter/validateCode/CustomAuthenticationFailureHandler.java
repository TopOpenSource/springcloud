package com.sdstc.config.securityFilter.validateCode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 过滤器失败处理器
 * 
 * @author cheng
 *
 */
@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

		Map<String, String> map = new HashMap<>();
		map.put("code", "500");
		map.put("msg", exception.getMessage());
        
		// 失败返回json
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().append(objectMapper.writeValueAsString(map));

	}
}
