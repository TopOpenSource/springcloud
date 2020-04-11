package com.sdstc.file.dto;

import lombok.Data;

@Data
public class PolicyDto {
	private String OSSAccessKeyId;
	private String policy;
	private String signature;
	private String dir;
	private String host;
	private String expire;
	private String callback;
}
