package com.sdstc.system.model;

import com.sdstc.pub.constant.PubConstant;
import com.sdstc.pub.constant.UserConstant;
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
	
	public UserInfo() {
		
	}
	public UserInfo(String account) {
    	this.account=account;
    	this.setIsDelete(PubConstant.IS_DELETE_N);
    	this.setState(UserConstant.STATE_Y);
    }
}
