package com.sdstc.system.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.sdstc.pub.dto.TokenDto;
import com.sdstc.system.model.UserInfo;
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

	@Override
	public TokenDto getToken(UserInfo userInfo) {
		ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://oauth2/oauth/token?grant_type=password&client_id=" + clientId + "&client_secret=" + clientPwd + "&username=" + userInfo.getAccount() + "&password=" + userInfo.getPwd(), null, String.class);
		if (responseEntity.getStatusCode().equals(HttpStatus.valueOf(200))) {
			HashMap result = JSONObject.parseObject(responseEntity.getBody(), HashMap.class);

			TokenDto token = new TokenDto();
			if (result.containsKey("access_token")) {
				token.setAccessToken(String.valueOf(result.get("access_token")));
			}

			if (result.containsKey("refresh_token")) {
				token.setRefreshToken(String.valueOf(result.get("refresh_token")));
			}

			if (result.containsKey("expires_in")) {
				token.setExpiresIn(Integer.valueOf(String.valueOf(result.get("expires_in"))));
			}

			return token;
		} else {
			return null;
		}
	}

	@Override
	public TokenDto refreshToken(String refreshToken) {
		ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://oauth2/oauth/token?grant_type=refresh_token&client_id=" + clientId + "&client_secret=" + clientPwd +"&refresh_token="+refreshToken, null, String.class);
		if (responseEntity.getStatusCode().equals(HttpStatus.valueOf(200))) {
			HashMap result = JSONObject.parseObject(responseEntity.getBody(), HashMap.class);

			TokenDto token = new TokenDto();
			if (result.containsKey("access_token")) {
				token.setAccessToken(String.valueOf(result.get("access_token")));
			}

			if (result.containsKey("refresh_token")) {
				token.setRefreshToken(String.valueOf(result.get("refresh_token")));
			}

			if (result.containsKey("expires_in")) {
				token.setExpiresIn(Integer.valueOf(String.valueOf(result.get("expires_in"))));
			}

			return token;
		} else {
			return null;
		}
	}

}
