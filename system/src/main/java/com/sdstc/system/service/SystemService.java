package com.sdstc.system.service;

import com.sdstc.pub.dto.ResultDto;
import com.sdstc.pub.exception.GetTokenException;
import com.sdstc.pub.exception.RefreshTokenException;
import com.sdstc.system.dto.TokenDto;
import com.sdstc.system.model.User;

public interface SystemService {
	TokenDto getToken(User userInfo)throws GetTokenException ;

	TokenDto refreshToken(String refreshToken)throws RefreshTokenException ;
	
	ResultDto removeToken();
}
