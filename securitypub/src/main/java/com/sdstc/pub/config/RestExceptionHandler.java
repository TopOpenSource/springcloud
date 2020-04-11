package com.sdstc.pub.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sdstc.pub.dto.ResultDto;
import com.sdstc.pub.exception.GetTokenException;
import com.sdstc.pub.exception.RefreshTokenException;

import lombok.extern.log4j.Log4j2;

/**
 * 统一异常处理  作用在 controller层 不能拦截springsecurity的401错误
 * @author cheng
 *
 */
@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ResultDto> handler(Exception e) {
		ResultDto result=new ResultDto();
		if (e instanceof AccessDeniedException) {
			log.error("exception:{}", e.getMessage(), e);
			result.setResult(ResultDto.ACCESS_FAILE);
			result.setMessage("无操作权限！");
		} else if (e instanceof GetTokenException) {
			log.error("exception:{}", e.getMessage(), e);
			result.setResult(ResultDto.GET_TOKEN_FAILE);
			result.setMessage("获取token 失败！");
		}  else if (e instanceof RefreshTokenException) {
			log.error("exception:{}", e.getMessage(), e);
			result.setResult(ResultDto.REFRESH_TOKEN_FAILE);
			result.setMessage("刷新 token 失败！");
		}  else {
			log.error("exception:{}", e.getMessage(), e);
			result.setResult(ResultDto.FAILE);
			result.setMessage("系统错误！");
		}
		
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);	
	}
}
