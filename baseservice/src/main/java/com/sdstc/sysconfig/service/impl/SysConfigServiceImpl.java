package com.sdstc.sysconfig.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.pub.utils.StringUtils;
import com.sdstc.redis.service.RedisService;
import com.sdstc.sysconfig.dao.SysConfigDao;
import com.sdstc.sysconfig.model.SysConfig;
import com.sdstc.sysconfig.service.SysConfigService;

@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService{
	@Autowired
    private SysConfigDao sysConfigDao;
	@Autowired
	private RedisService redisService;
	
	public static final String CONFIG_HEADER="sys_config_";
	public static final String INTER_CHAR="_";
	
	@Override
	public Integer getConfigAsInt(String type, String key) {
		String value=this.getConfigAsStr(type, key);
		if(StringUtils.isEmpty(value)) {
			return null;
		}else {
			return Integer.valueOf(value);
		}
	}

	@Override
	public String getConfigAsStr(String type, String key) {
		//首先查询redis
		String redisKey=CONFIG_HEADER+type+INTER_CHAR+key;
		String value=redisService.getValue(redisKey);
		if(value==null) {
			SysConfig sysConfig=sysConfigDao.selConfig(type, key);
			if(sysConfig!=null) {
				value=sysConfig.getValue();
				//将结果存入redis
				redisService.setKey(redisKey, value, -1);
				return value;
			}else {
				return null;
			}
		}else {
			return value;
		}
	}

}
