package com.sdstc.system.service;

import com.sdstc.pub.dto.ResultDto;
import com.sdstc.pub.exception.GetTokenException;
import com.sdstc.pub.exception.RefreshTokenException;
import com.sdstc.system.dto.TokenDto;
import com.sdstc.system.model.SysUser;
import com.sdstc.system.model.UserInfo;

public interface SystemService {
	TokenDto getToken(UserInfo userInfo)throws GetTokenException ;

	TokenDto refreshToken(String refreshToken)throws RefreshTokenException ;
	
	ResultDto removeToken();
	
	/**
	 * 客户注册
	 * @return 结果对象
	 */
	ResultDto customRegister(SysUser dto);
}
