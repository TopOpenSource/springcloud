package com.sdstc.system.dao;

import com.sdstc.system.dao.base.SysUserExtBaseDao;
import com.sdstc.system.model.UserExt;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface SysUserExtDao extends SysUserExtBaseDao{
   List<UserExt> selectByDto(UserExt dto);
   Integer selectCountByDto(UserExt dto);
   List<UserExt> selectPageByDto(@Param("dto") UserExt dto, @Param("pageDto")PageDto pageDto);
   UserExt selectByUserDto(UserInfo dto);
   void  updateSelectiveByUserAccount(UserExt dto);
}
