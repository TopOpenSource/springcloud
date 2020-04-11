package com.sdstc.pub.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.sdstc.pub.dto.ResultDto;

import lombok.extern.log4j.Log4j2;

/**
   * 匿名用户访问无权限资源时的异常处理
 * @author cheng
 *
 */
@Component("tokenExceptionEntryPoint")
@Log4j2
public class TokenExceptionEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		ResultDto resultDto=new ResultDto();
		Throwable cause = authException.getCause();
		if (cause instanceof InvalidTokenException) {
			resultDto.setResult(ResultDto.INVALIDTOKEN);
			resultDto.setMessage("无效的token！");
		} else {
			resultDto.setResult(ResultDto.ACCESS_FAILE);
			resultDto.setMessage("权限不足！");
		}
		
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(response.getOutputStream(), resultDto);
		} catch (Exception e) {
			throw new ServletException();
		}
		
	}

}
