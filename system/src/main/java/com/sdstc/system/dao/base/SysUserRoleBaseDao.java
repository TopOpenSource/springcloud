package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.SysUserRole;


public interface SysUserRoleBaseDao {
   void  insert(SysUserRole dto);
   void  updateByPK(SysUserRole dto);
   void  updateSelectiveByPK(SysUserRole dto);
   void  deleteByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   SysUserRole  selectByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   
}
