package com.sdstc.pub.exception;

/**
 * 刷新token失败异常
 * @author cheng
 *
 */
public class RefreshTokenException extends Exception{
	private static final long serialVersionUID = 1210902815649152635L;

	public RefreshTokenException() {
		super();
	}

	public RefreshTokenException(String msg) {
		super(msg);
	}
}
