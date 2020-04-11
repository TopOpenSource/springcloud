package com.sdstc.service;

import java.util.List;

import com.sdstc.model.Tenant;
import com.sdstc.model.User;
import com.sdstc.model.UserSecurity;

public interface UserService {
    
	/**
	 * 获取所属客户
	 * @param user
	 * @return
	 */
	List<Tenant> getTenantsByUser(User user);
	
	/**
	   * 获取账户信息
	 * @param account
	 * @return
	 */
	User getUser(String account);
	
	/**
	 *  拼装 UserSecurity 用于OAuth2验证
	 * @param account
	 * @param tenantId
	 * @param authType  验证类型
	 * @return
	 */
	UserSecurity getUserSecurity(String account,Long tenantId,String authType);
}
