package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserInfo extends BaseModel{
	private Long id;
	private String account;
	private String phone;
	private String email;
	private String name;
	private String pwd;
	private String state;
}
