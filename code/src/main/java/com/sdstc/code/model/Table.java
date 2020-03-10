package com.sdstc.code.model;

import lombok.Data;

@Data
public class Table {
	//是否包含 integer
	private Boolean hasInteger;
	//是否包含 string
	private Boolean hasString;
	//是否包含 char
	private Boolean hasChar;
	//是否包含 long
	private Boolean hasLong;
	//是否包含 date
	private Boolean hasDate;
	//是否包含租户字段
	private Boolean hasTenant;
	//主键
	private String primaryKey;
	//租户键
	private String tenantKey;

	//实体名
	private String entityName;
	//dao路径
	private String daoPath;
	//model路径
	private String modelPath;
	//xml路径
	private String xmlPath;
	
}
