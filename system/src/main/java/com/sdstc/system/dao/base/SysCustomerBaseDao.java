package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.SysCustomer;


public interface SysCustomerBaseDao {
   void  insert(SysCustomer dto);
   void  updateByPK(SysCustomer dto);
   void  updateSelectiveByPK(SysCustomer dto);
   void  deleteByPK(@Param("id") Long id);
   SysCustomer  selectByPK(@Param("id") Long id);
   
}
