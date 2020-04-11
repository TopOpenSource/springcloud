package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.UserRole;


public interface SysUserRoleBaseDao {
   void  insert(UserRole dto);
   void  updateByPK(UserRole dto);
   void  updateSelectiveByPK(UserRole dto);
   void  deleteByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   UserRole selectByPK(@Param("id") Long id, @Param("customerId") Long customerId);
   
}
