package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.PubFileRelation;


public interface PubFileRelationBaseDao {
   void  insert(PubFileRelation dto);
   void  updateByPK(PubFileRelation dto);
   void  updateSelectiveByPK(PubFileRelation dto);
   void  deleteByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   PubFileRelation  selectByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   
}
