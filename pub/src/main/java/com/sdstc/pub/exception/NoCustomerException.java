package com.sdstc.pub.exception;

/**
 * 
 * @author cheng
 *
 */
public class NoCustomerException extends Exception{
	private static final long serialVersionUID = 1210902815649152635L;

	public NoCustomerException() {
		super();
	}

	public NoCustomerException(String msg) {
		super(msg);
	}
}
