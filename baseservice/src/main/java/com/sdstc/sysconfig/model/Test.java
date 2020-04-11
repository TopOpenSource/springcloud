package com.sdstc.sysconfig.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Test {

	public static void main(String[] args) {
		SysConfig sysConfig = new SysConfig();
		sysConfig.setId(1l);
		sysConfig.setKey("1");
		sysConfig.setA(null);
		String a = JSONObject.toJSONString(sysConfig, SerializerFeature.WriteMapNullValue);
		System.out.println(a);
	}

}
