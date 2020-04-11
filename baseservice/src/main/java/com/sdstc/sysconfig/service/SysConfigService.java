package com.sdstc.sysconfig.service;

public interface SysConfigService {
	/**
	 * 获取配置信息
	 * @param key
	 * @return
	 */
	Integer getConfigAsInt(String type,String key);
    /**
     * 获取配置信息
     * @param key
     * @return
     */
	String getConfigAsStr(String type,String key);
}
