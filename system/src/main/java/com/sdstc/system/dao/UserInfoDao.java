package com.sdstc.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sdstc.system.model.UserInfo;

public interface UserInfoDao {
	void insert(UserInfo dto);

	void upUser(@Param("id") Long id, @Param("values") Map<String, Object> values);

	List<UserInfo> selUserInfos(UserInfo dto);
	
	List<UserInfo> selUserInfosPage(UserInfo dto);

	UserInfo selUserInfoById(@Param("id")Long id);
}
