package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.User;


public interface SysUserBaseDao {
   void  insert(User dto);
   void  updateByPK(User dto);
   void  updateSelectiveByPK(User dto);
   void  deleteByPK(@Param("id") Long id);
   User selectByPK(@Param("id") Long id);
   
}
