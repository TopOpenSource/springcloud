package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.Org;


public interface SysOrgBaseDao {
   void  insert(Org dto);
   void  updateByPK(Org dto);
   void  updateSelectiveByPK(Org dto);
   void  deleteByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   Org selectByPK(@Param("id") Long id, @Param("customerId") Long customerId);
   
}
