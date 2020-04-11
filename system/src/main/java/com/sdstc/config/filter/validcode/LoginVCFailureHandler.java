package com.sdstc.config.filter.validcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.pub.exception.ValidCodeException;
import com.sdstc.pub.filter.FailureHandler;

/**
 * 验证码验证失败处理器(由于未到controller 无法统一异常处理)
 * 
 * @author cheng
 *
 */
@Component("loginVCFailureHandler")
public class LoginVCFailureHandler extends SimpleUrlAuthenticationFailureHandler implements FailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		ResultDto result=new ResultDto(ResultDto.VALIDCODE_FAILE,exception.getMessage());
		// 失败返回json
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(500);
		response.getWriter().append(new ObjectMapper().writeValueAsString(result));
	}

	@Override
	public void doResult(HttpServletRequest request, HttpServletResponse response,ResultDto dto) throws IOException, ServletException{
		this.onAuthenticationFailure(request, response, new ValidCodeException(dto.getMessage()));
	}
}
