package com.sdstc.code.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sdstc.code.model.Column;

public interface TableMapper {
	List<Column> getColumns(@Param("tableName")String tableName,@Param("scheme")String scheme);
}
