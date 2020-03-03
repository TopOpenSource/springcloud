package com.sdstc.pub.exception;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sdstc.pub.dto.ResultDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public ResultDto handler(Exception e) {
		if (e instanceof IOException) {
			return new ResultDto(200, "SUCCESS");
		} else if (e instanceof AccessDeniedException) {
			log.error("exception:{}", e.getMessage(), e);
			return new ResultDto(403, "无权限!");
		} else {
			log.error("exception:{}", e.getMessage(), e);
			return new ResultDto(500, "服务器内部错误,请联系系统管理员!");
		}
	}
}
