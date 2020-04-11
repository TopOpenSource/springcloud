package com.sdstc.pub.exception;

/**
 * 获取token失败异常
 * @author cheng
 *
 */
public class GetTokenException extends Exception{
	private static final long serialVersionUID = 1210902815649152635L;

	public GetTokenException() {
		super();
	}

	public GetTokenException(String msg) {
		super(msg);
	}
}
