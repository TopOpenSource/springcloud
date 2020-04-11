package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.SysUserExt;


public interface SysUserExtBaseDao {
   void  insert(SysUserExt dto);
   void  updateByPK(SysUserExt dto);
   void  updateSelectiveByPK(SysUserExt dto);
   void  deleteByPK(@Param("id") Long id);
   SysUserExt  selectByPK(@Param("id") Long id);
   
}
