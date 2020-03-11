package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.PubLog;


public interface PubLogBaseDao {
   void  insert(PubLog dto);
   void  updateByPK(PubLog dto);
   void  updateSelectiveByPK(PubLog dto);
   void  deleteByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   PubLog  selectByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   
}
