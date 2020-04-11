package com.sdstc.model;

import lombok.Data;

@Data
public class UserInfo {
	private Long id;
	private String account;
	private String name;
	//密码
	private String pwd;
	//短信验证码
	private String smsCode;
	//客户ID
	private Long customerId;
	
	public UserInfo() {
		
	}
	public UserInfo(String account,Long customerId) {
		this.account=account;
		this.customerId=customerId;
	}
}
