package com.sdstc.system.dao;

import com.sdstc.system.model.Customer;

public interface CustomerDao {
   void  insertCustomer(Customer dto);
   void  insertCustomerState(Customer dto);
}
