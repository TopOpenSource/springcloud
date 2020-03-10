package com.sdstc.code.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Params {
	//数据库与JAVA 类型映射
	public static Map<String, String> colTypes = new HashMap<String, String>() {
		{
			colTypes.put("date", "Date");
			colTypes.put("datetime", "Date");
			colTypes.put("varchar", "String");
			colTypes.put("bigint", "Long");
			colTypes.put("char", "Char");
			colTypes.put("int", "Integer");
		}
	};
	
	public static Set<String> parentColumns=new HashSet<String>() {
		{
			parentColumns.add("gmt_create");
			parentColumns.add("gmt_modified");
			parentColumns.add("create_account");
			parentColumns.add("modified_account");
		}
	};

}
