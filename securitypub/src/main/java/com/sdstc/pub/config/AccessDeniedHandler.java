package com.sdstc.pub.config;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdstc.pub.dto.ResultDto;

import lombok.extern.log4j.Log4j2;

/**
 * 认证过的用户访问无权限资源时的异常处理
 * 
 * @author cheng
 *
 */
@Component
@Log4j2
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		ResultDto resultDto=new ResultDto();
		resultDto.setResult(ResultDto.ACCESS_FAILE);
		resultDto.setMessage("权限不足！");
		// 失败返回json
		ObjectMapper objectMapper=new ObjectMapper();
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().append(objectMapper.writeValueAsString(resultDto));
	}

}
