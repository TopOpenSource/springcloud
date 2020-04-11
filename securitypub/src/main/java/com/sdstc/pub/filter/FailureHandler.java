package com.sdstc.pub.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdstc.pub.dto.ResultDto;

public interface FailureHandler {
	void doResult(HttpServletRequest request, HttpServletResponse response,ResultDto dto) throws IOException, ServletException;
}
