package com.sdstc.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.pub.exception.GetTokenException;
import com.sdstc.pub.exception.RefreshTokenException;
import com.sdstc.pub.oauth.service.Snowflake;
import com.sdstc.system.dao.SysCustomerDao;
import com.sdstc.system.dao.SysOrgDao;
import com.sdstc.system.dto.TokenDto;
import com.sdstc.system.model.User;
import com.sdstc.system.service.SystemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

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
    private Snowflake snowflake;

    @Override
    public TokenDto getToken(User userInfo) throws GetTokenException {
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                    "http://oauth2/oauth/token?grant_type=password&client_id=" + clientId + "&client_secret=" + clientPwd + "&username=" + userInfo.getAccount() + "&password=" + userInfo.getPwd(), null, String.class);
            return JSONObject.parseObject(responseEntity.getBody(), TokenDto.class);
        } catch (HttpClientErrorException e) {
            log.error("get token fail" + userInfo.getAccount());
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
        return new ResultDto(ResultDto.SUCCESS, null);
    }
}
