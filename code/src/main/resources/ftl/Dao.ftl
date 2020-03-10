package com.sdstc.system.dao;

import java.util.List;
import com.sdstc.system.model.Customer;

public interface CustomerDao {
   void  insert(Customer dto);
   void  updateByPK(Customer dto);
   void  updateSelectiveByPK(Customer dto);
   void  deleteByPK(@Param("id") Long id,@Param("id") Long id);
   Customer  selectByPK(@Param("id") Long id,@Param("id") Long id);
   List<Customer> selectByDto(Customer dto);
   
}
