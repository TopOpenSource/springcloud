package com.sdstc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sdstc.model.Customer;
import com.sdstc.model.Perm;
import com.sdstc.model.Role;
import com.sdstc.model.UserInfo;

/**
 * 
 * @author cheng
 *
 */
public interface UserDao {
   UserInfo getUser(@Param("account")String account);
   List<Role> getRolesByUser(@Param("account")String account,@Param("customerId")Long customerId);
   List<Perm> getPermsByUser(@Param("account")String account,@Param("customerId")Long customerId);
   List<Customer> getCustomersByUser(@Param("account")String account);
}
