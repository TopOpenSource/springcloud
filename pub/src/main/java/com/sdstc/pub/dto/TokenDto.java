package com.sdstc.pub.dto;

import lombok.Data;

@Data
public class TokenDto {
	private String accessToken;
	private String refreshToken;
	private Integer expiresIn;
}
