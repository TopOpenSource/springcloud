package com.sdstc.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.pub.constant.UserConstant;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.pub.exception.GetTokenException;
import com.sdstc.pub.exception.RefreshTokenException;
import com.sdstc.pub.utils.StringUtils;
import com.sdstc.system.dto.TokenDto;
import com.sdstc.system.model.SysUser;
import com.sdstc.system.model.UserInfo;
import com.sdstc.system.service.SystemService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/system/system")
@Log4j2
public class SystemController {
	@Autowired
	private SystemService systemService;
	
	@RequestMapping("login")
	public TokenDto login(UserInfo userInfo) throws GetTokenException {
		if(StringUtils.isEmpty(userInfo.getAccount())||StringUtils.isEmpty(userInfo.getPwd())) {
			log.error("account or pwd is null!");
			return new TokenDto(ResultDto.GET_TOKEN_FAILE);
		}else{
			log.info(userInfo.getAccount()+":login");
			return systemService.getToken(userInfo);
		}
	}

	@RequestMapping("refreshToken")
	public TokenDto refreshToken(String refreshToken) throws RefreshTokenException {
		if(StringUtils.isEmpty(refreshToken)) {
			log.error("refreshToken is null!");
			return new TokenDto(ResultDto.REFRESH_TOKEN_FAILE);
		}else {
			return systemService.refreshToken(refreshToken);
		}
	}
	
	@RequestMapping("removeToken")
	public ResultDto removeToken(){
		return systemService.removeToken();
	}
	
	/**
	 * 客户注册
	 * @return 结果对象
	 */
	@RequestMapping("customRegister")
	public ResultDto customRegister(SysUser dto) {
		
		ResultDto resultDto=new ResultDto(1,"");
		dto.setCreateAccount(UserConstant.SYSTEM);
		dto.setState("1");
		systemService.customRegister(dto);
		
		return resultDto;
	}
	
}
