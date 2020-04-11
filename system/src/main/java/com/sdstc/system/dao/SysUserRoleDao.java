package com.sdstc.system.dao;

import com.sdstc.system.dao.base.SysUserRoleBaseDao;
import com.sdstc.system.model.UserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface SysUserRoleDao extends SysUserRoleBaseDao{
   List<UserRole> selectByDto(UserRole dto);
   Integer selectCountByDto(UserRole dto);
   List<UserRole> selectPageByDto(@Param("dto") UserRole dto, @Param("pageDto")PageDto pageDto);
   void insertBatch(@Param("dtos") List<UserRole> dtos);
}
