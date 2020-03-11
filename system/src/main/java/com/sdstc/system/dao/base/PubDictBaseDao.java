package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.PubDict;


public interface PubDictBaseDao {
   void  insert(PubDict dto);
   void  updateByPK(PubDict dto);
   void  updateSelectiveByPK(PubDict dto);
   void  deleteByPK(@Param("id") Long id);
   PubDict  selectByPK(@Param("id") Long id);
   
}
