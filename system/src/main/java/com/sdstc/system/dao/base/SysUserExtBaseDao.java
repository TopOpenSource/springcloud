package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.UserExt;


public interface SysUserExtBaseDao {
   void  insert(UserExt dto);
   void  updateByPK(UserExt dto);
   void  updateSelectiveByPK(UserExt dto);
   void  deleteByPK(@Param("id") Long id);
   UserExt selectByPK(@Param("id") Long id);
   
}
