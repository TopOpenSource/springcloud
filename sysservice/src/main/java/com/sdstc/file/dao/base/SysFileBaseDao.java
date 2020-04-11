package com.sdstc.file.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.file.model.SysFile;


public interface SysFileBaseDao {
   void  insert(SysFile dto);
   void  updateByPK(SysFile dto);
   void  updateSelectiveByPK(SysFile dto);
   void  deleteByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   SysFile  selectByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   
}
