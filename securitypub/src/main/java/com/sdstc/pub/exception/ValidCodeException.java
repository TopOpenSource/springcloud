package com.sdstc.pub.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码验证失败异常
 * @author cheng
 *
 */
public class ValidCodeException extends  AuthenticationException{
	public ValidCodeException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1210902815649152635L;

	
}
