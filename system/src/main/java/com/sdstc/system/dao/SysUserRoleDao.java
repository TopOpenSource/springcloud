package com.sdstc.system.dao;

import com.sdstc.system.dao.base.SysUserRoleBaseDao;
import com.sdstc.system.model.SysUserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface SysUserRoleDao extends SysUserRoleBaseDao{
   List<SysUserRole> selectByDto(SysUserRole dto);
   Integer selectCountByDto(SysUserRole dto);
   List<SysUserRole> selectPageByDto(@Param("dto")SysUserRole dto,@Param("pageDto")PageDto pageDto);
   void insertBatch(@Param("dtos") List<SysUserRole> dtos);
}
