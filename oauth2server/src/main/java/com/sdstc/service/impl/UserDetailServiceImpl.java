package com.sdstc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sdstc.dao.RedisDao;
import com.sdstc.dao.UserDao;
import com.sdstc.model.Customer;
import com.sdstc.model.Perm;
import com.sdstc.model.Role;
import com.sdstc.model.UserInfo;
import com.sdstc.model.UserSecurity;

import lombok.extern.slf4j.Slf4j;

@Service("userDetailService")
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private RedisDao redisDao;
	@Autowired
	private  UserDao userDao;

	public static final String redisHeader="current_customer_";
	
	@Value("${oauth2.refreshTokenValiditySeconds}")
	private Integer refreshTokenValiditySeconds;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserInfo userInfo=userDao.getUser(username);
		if(userInfo!=null) {
			Long customerId=this.getCustomerId(userInfo.getAccount());
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			//获取角色
			List<Role> roles=userDao.getRolesByUser(username,customerId);
			for(Role role:roles) {
				authorities.add(new SimpleGrantedAuthority(role.getCode()));  
				
			}
			//获取权限
			List<Perm> perms=userDao.getPermsByUser(username,customerId);
			for(Perm perm:perms) {
				authorities.add(new SimpleGrantedAuthority(perm.getCode()));
			}
			//生成 springsecurity User
			UserSecurity user = new UserSecurity(username,userInfo.getPwd(),customerId,authorities);
			return user;
		}else {
			return null;
		}
	}

	//获取所在单位ID
	private Long getCustomerId(String account){
		Long currentCustomerId=(Long) redisDao.getValueObject(redisHeader+account);
		if(currentCustomerId==null) {
			List<Customer> customers=userDao.getCustomersByUser(account);
			if(customers.size()>0) {
				Customer customer=customers.get(0);
				redisDao.setKey(redisHeader+account, customer.getId(), refreshTokenValiditySeconds*1000);
				return customer.getId();
			}else {
				log.error("the loger has not customers");
				return null;
			}
		}else {
			redisDao.setKey(redisHeader+account, currentCustomerId, refreshTokenValiditySeconds*1000);
			return currentCustomerId;
		}
	}
	
}
