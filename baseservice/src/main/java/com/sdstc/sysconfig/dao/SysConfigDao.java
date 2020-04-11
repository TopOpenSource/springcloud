package com.sdstc.sysconfig.dao;

import org.apache.ibatis.annotations.Param;

import com.sdstc.sysconfig.model.SysConfig;

public interface SysConfigDao {
	SysConfig selConfig(@Param("type")String type,@Param("key")String key);
}
