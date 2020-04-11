package com.sdstc.model;

import lombok.Data;

@Data
public class User {
	private Long id;
	private String account;
	private String name;
	//密码
	private String pwd;
	//短信验证码
	private String smsCode;
	//租户ID
	private Long tenantId;
	
	public User() {
		
	}
	public User(String account, Long tenantId) {
		this.account=account;
		this.tenantId=tenantId;
	}
}
