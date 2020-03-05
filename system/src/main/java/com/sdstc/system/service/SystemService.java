package com.sdstc.system.service;

import com.sdstc.pub.dto.TokenDto;
import com.sdstc.system.model.Client;
import com.sdstc.system.model.UserInfo;

public interface SystemService {
	TokenDto getToken(UserInfo userInfo);

	TokenDto refreshToken(String refreshToken);
}
