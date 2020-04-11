package com.sdstc.service;

import java.util.List;

import com.sdstc.model.Customer;
import com.sdstc.model.UserInfo;
import com.sdstc.model.UserSecurity;

public interface UserService {
    
	/**
	 * 获取所属客户
	 * @param user
	 * @return
	 */
	List<Customer> getCustomersByUser(UserInfo user);
	
	/**
	   * 获取账户信息
	 * @param account
	 * @return
	 */
	UserInfo getUser(String account);
	
	/**
	 *  拼装 UserSecurity 用于OAuth2验证
	 * @param account
	 * @param customerId
	 * @param authType  验证类型
	 * @return
	 */
	UserSecurity getUserSecurity(String account,Long customerId,String authType);
}
