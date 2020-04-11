package com.sdstc.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.sdstc.pub.constant.RoleConstant;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.pub.exception.GetTokenException;
import com.sdstc.pub.exception.RefreshTokenException;
import com.sdstc.pub.oauth.service.Snowflake;
import com.sdstc.system.dao.SysCustomerDao;
import com.sdstc.system.dao.SysOrgDao;
import com.sdstc.system.dto.TokenDto;
import com.sdstc.system.model.SysCustomer;
import com.sdstc.system.model.SysOrg;
import com.sdstc.system.model.SysUser;
import com.sdstc.system.model.SysUserExt;
import com.sdstc.system.model.SysUserOrg;
import com.sdstc.system.model.SysUserRole;
import com.sdstc.system.model.UserInfo;
import com.sdstc.system.service.SysUserExtService;
import com.sdstc.system.service.SysUserOrgService;
import com.sdstc.system.service.SysUserRoleService;
import com.sdstc.system.service.SysUserService;
import com.sdstc.system.service.SystemService;

import lombok.extern.log4j.Log4j2;

@Service("systemService")
@Log4j2
public class SystemServiceImpl implements SystemService {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${security.oauth2.client.client-id}")
	private String clientId;
	@Value("${security.oauth2.client.client-secret}")
	private String clientPwd;

	@Autowired
	private SysUserExtService  sysUserExtService; 
	
	@Autowired
    private Snowflake snowflake;
	
	@Autowired
	private SysCustomerDao sysCustomerDao;
	
	@Autowired
	private SysOrgDao sysOrgDao;
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private SysUserOrgService sysUserOrgService;
	
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	@Override
	public TokenDto getToken(UserInfo userInfo) throws GetTokenException {
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(
					"http://oauth2/oauth/token?grant_type=password&client_id=" + clientId + "&client_secret=" + clientPwd + "&username=" + userInfo.getAccount() + "&password=" + userInfo.getPwd(), null, String.class);
			return JSONObject.parseObject(responseEntity.getBody(), TokenDto.class);
		} catch (HttpClientErrorException e) {
			log.error("get token fail" + userInfo.getAccount());
			//更新登录失败次数
			sysUserExtService.updateLoginFaildInfo(userInfo.getAccount());
			throw new GetTokenException("get Token error!");
		}
	}

	@Override
	public TokenDto refreshToken(String refreshToken) throws RefreshTokenException {
		try {
			ResponseEntity<String> responseEntity = restTemplate
					.postForEntity("http://oauth2/oauth/token?grant_type=refresh_token&client_id=" + clientId + "&client_secret=" + clientPwd + "&refresh_token=" + refreshToken, null, String.class);
			return JSONObject.parseObject(responseEntity.getBody(), TokenDto.class);
		} catch (HttpClientErrorException e) {
			log.error("refresh token fail" + refreshToken);
			throw new RefreshTokenException("refresh Token error!");
		}
	}

	@Override
	public ResultDto removeToken() {
		restTemplate.postForEntity("http://oauth2//api/oauth2/removeToken", null, String.class);
		return new ResultDto(ResultDto.SUCCESS,null);
	}

	@Override
	@Transactional
	public ResultDto customRegister(SysUser dto) {
		
		SysCustomer sysCustomer = new SysCustomer();// 客户对象
		SysOrg sysOrg = new SysOrg();// 组对象
		SysUserOrg sysUserOrg = new SysUserOrg();// 用户与组关系对象
		List<SysUserRole> surList = new ArrayList<SysUserRole>();// 用户与角色关系集合对象
		SysUserExt sysUserExt = new SysUserExt();// 用户扩展对象
		Date now=new Date();// 获取当前时间
		
		/**
		 * 创建客户信息
		 */
		Long customerId = snowflake.getId();
		sysCustomer.setId(customerId);
		sysCustomer.setCreateAccount(dto.getCreateAccount());
		sysCustomer.setGmtCreate(now);
		sysCustomer.setState("0");
		
		sysCustomerDao.insert(sysCustomer);
		
		/**
		 * 创建组信息
		 */
		Long orgId = snowflake.getId();
		sysOrg.setId(orgId);
		sysOrg.setCreateAccount(dto.getCreateAccount());
		sysOrg.setGmtCreate(now);
		sysOrg.setCustomerId(customerId);
		
		sysOrgDao.insert(sysOrg);
		
		/**
		 * 保存用户信息
		 */
		sysUserService.insert(dto);
		
		/**
		 * 保存用户与组关系信息
		 */
		sysUserOrg.setCreateAccount(dto.getCreateAccount());
		sysUserOrg.setCustomerId(customerId);
		sysUserOrg.setOrgId(orgId);
		sysUserOrg.setUserAccount(dto.getAccount());
		
		sysUserOrgService.insert(sysUserOrg);
		
		/**
		 * 保存用户与角色关系信息
		 */
		SysUserRole sysUserRole = new SysUserRole(snowflake.getId(), dto.getCreateAccount(), now, dto.getAccount(), RoleConstant.ROLE_CUSTOMER, customerId);// 用户与角色关系对象
		surList.add(sysUserRole);
		
		sysUserRole = new SysUserRole(snowflake.getId(), dto.getCreateAccount(), now, dto.getAccount(), RoleConstant.ROLE_CUSTOMER_ADMIN, customerId);// 用户与角色关系对象
		surList.add(sysUserRole);
		
		sysUserRoleService.insertBatch(surList);
		
		/**
		 * 保存用户扩展信息
		 */
		sysUserExt.setCreateAccount(dto.getCreateAccount());
		sysUserExt.setUserAccount(dto.getAccount());
		
		sysUserExtService.insert(sysUserExt);
		
		return new ResultDto(ResultDto.SUCCESS,null);
		
	}

}
