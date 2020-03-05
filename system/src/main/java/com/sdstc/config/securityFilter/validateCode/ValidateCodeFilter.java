package com.sdstc.config.securityFilter.validateCode;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sdstc.config.exception.ValidCodeException;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ValidateCodeFilter extends OncePerRequestFilter {
	@Setter
	private AuthenticationFailureHandler authenticationFailureHandler;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		log.info("valid code");
		if(request.getRequestURI().equals("/api/system/system/login") && request.getMethod().equals("POST")){
			String validateCode = request.getParameter("validateCode");
			if (validateCode != null && validateCode.equals("abc")) {
				authenticationFailureHandler.onAuthenticationFailure(request, response, new ValidCodeException("xxx"));
			} else {
				filterChain.doFilter(request, response);
			}
		}else {
			filterChain.doFilter(request, response);
		}
	}

}
