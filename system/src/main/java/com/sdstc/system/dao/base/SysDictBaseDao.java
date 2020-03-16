package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.SysDict;


public interface SysDictBaseDao {
   void  insert(SysDict dto);
   void  updateByPK(SysDict dto);
   void  updateSelectiveByPK(SysDict dto);
   void  deleteByPK(@Param("id") Long id);
   SysDict  selectByPK(@Param("id") Long id);
   
}
