package com.sdstc.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sdstc.pub.dto.PageDto;
import com.sdstc.system.dao.base.SysDictBaseDao;
import com.sdstc.system.model.SysDict;

public interface SysDictDao extends SysDictBaseDao{
   List<SysDict> selectByDto(SysDict dto);
   Integer selectCountByDto(SysDict dto);
   List<SysDict> selectPageByDto(@Param("dto")SysDict dto,@Param("pageDto")PageDto pageDto);
}
