package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.SysUserOrg;


public interface SysUserOrgBaseDao {
   void  insert(SysUserOrg dto);
   void  updateByPK(SysUserOrg dto);
   void  updateSelectiveByPK(SysUserOrg dto);
   void  deleteByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   SysUserOrg  selectByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   
}
