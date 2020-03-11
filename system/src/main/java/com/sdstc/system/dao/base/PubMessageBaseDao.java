package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.PubMessage;


public interface PubMessageBaseDao {
   void  insert(PubMessage dto);
   void  updateByPK(PubMessage dto);
   void  updateSelectiveByPK(PubMessage dto);
   void  deleteByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   PubMessage  selectByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   
}
