package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.Customer;


public interface SysCustomerBaseDao {
   void  insert(Customer dto);
   void  updateByPK(Customer dto);
   void  updateSelectiveByPK(Customer dto);
   void  deleteByPK(@Param("id") Long id);
   Customer selectByPK(@Param("id") Long id);
   
}
