package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.UserOrg;


public interface SysUserOrgBaseDao {
   void  insert(UserOrg dto);
   void  updateByPK(UserOrg dto);
   void  updateSelectiveByPK(UserOrg dto);
   void  deleteByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   UserOrg selectByPK(@Param("id") Long id, @Param("customerId") Long customerId);
   
}
