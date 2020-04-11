package com.sdstc.email.dto;

import lombok.Data;

@Data
public class EmailDto {
	private String toEmail;// 发送给
	private String subject;// 标题
	private String text;// 发送内容
}
