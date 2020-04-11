package com.sdstc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.sdstc.dao.UserDao;
import com.sdstc.integration.IntegrationAuthentication;
import com.sdstc.model.Tenant;
import com.sdstc.model.Perm;
import com.sdstc.model.Role;
import com.sdstc.model.User;
import com.sdstc.model.UserSecurity;
import com.sdstc.pub.utils.StringUtils;
import com.sdstc.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisService redisService;

	public static final String redisHeader = "current_tenant_";
	
	private static final String SMS_CODE_HEADER="LOGIN_SMS_CODE_";

	/**
	 * 获取角色
	 * 
	 * @param account
	 * @param tenantId
	 * @return
	 */
	private List<Role> getRolesByUser(String account, Long tenantId) {
		return userDao.getRolesByUser(account, tenantId);
	}

	/**
	 * 获取权限
	 * 
	 * @param account
	 * @param tenantId
	 * @return
	 */
	private List<Perm> getPermsByUser(String account, Long tenantId) {
		return userDao.getPermsByUser(account, tenantId);
	}

	@Override
	public List<Tenant> getTenantsByUser(User user) {
		return userDao.getTenantsByUser(user);
	}

	@Override
	public User getUser(String account) {
		User userInfo=userDao.getUser(account);
		//获取短信验证码
		String smsCode=redisService.getValue(SMS_CODE_HEADER+account);
		if(!StringUtils.isEmpty(smsCode)) {
			userInfo.setSmsCode(smsCode);
		}
		return userInfo;
	}

	@Override
	public UserSecurity getUserSecurity(String account, Long tenantId, String authType) {
		// 获取用户信息
		User userInfo = this.getUser(account);
		// 获取所属的全部客户信息
		List<Tenant> tenants = this.getTenantsByUser(new User(account, null));

		Tenant tenant = null;
		if (tenantId == null) {
			// 默认取第一个
			tenant = tenants.get(0);
		} else {
			List<Tenant> tenants2 = tenants.stream().filter(x -> {
				return x.getId().equals(tenantId);
			}).collect(Collectors.toList());
			if (tenants2 != null && tenants2.size() == 1) {
				tenant = tenants2.get(0);
			} else {
				log.error("no cusotemer!");
				return null;
			}
		}

		if (userInfo != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			// 获取角色
			List<Role> roles = this.getRolesByUser(account, tenant.getId());
			for (Role role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getCode()));

			}
			// 获取权限
			List<Perm> perms = this.getPermsByUser(account, tenant.getId());
			for (Perm perm : perms) {
				authorities.add(new SimpleGrantedAuthority(perm.getCode()));
			}
			// 生成 springsecurity User
			UserSecurity user=null;
			if(authType==null) {
				authType=IntegrationAuthentication.PWD;
			}
			
			if(IntegrationAuthentication.PWD.equals(authType)) {
				user = new UserSecurity(account, userInfo.getPwd(), authorities);
			}else if(IntegrationAuthentication.SMS.equals(authType)) {
				user = new UserSecurity(account, userInfo.getSmsCode(), authorities);
			}else {
				log.error("不支持此验证类型"+authType);
			}
			user.setTenant(tenant);
			user.setTenants(tenants);
			user.setUserName(userInfo.getName());
			return user;
		} else {
			return null;
		}
	}
}
