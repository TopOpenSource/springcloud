package com.sdstc.config.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 
 * @author cheng
 *
 */
public class ValidCodeException extends  AuthenticationException{
	public ValidCodeException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1210902815649152635L;

	
}
