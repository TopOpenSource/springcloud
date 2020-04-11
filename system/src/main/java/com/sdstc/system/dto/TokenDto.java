package com.sdstc.system.dto;

import com.sdstc.system.model.Customer;
import lombok.Data;

import java.util.List;

@Data
public class TokenDto {
	private String access_token;
	private String refresh_token;
	private Integer expires_in;
	
	private String userAccount;
	private String userName;
	private Customer customer;
	private List<Customer> customers;
	private List<String> auths;
	/**
	 * 防止返回控制
	 * 0 null 1有值
	 */
	private Integer result;

	public TokenDto() {
		
	}
	public TokenDto(Integer result) {
		this.result=result;
	}
	
}
