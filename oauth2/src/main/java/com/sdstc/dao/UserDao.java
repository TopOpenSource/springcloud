package com.sdstc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sdstc.model.Tenant;
import com.sdstc.model.Perm;
import com.sdstc.model.Role;
import com.sdstc.model.User;

/**
 * 
 * @author cheng
 *
 */
public interface UserDao {
   User getUser(@Param("account")String account);
   List<Role> getRolesByUser(@Param("account")String account,@Param("tenantId")Long tenantId);
   List<Perm> getPermsByUser(@Param("account")String account,@Param("tenantId")Long tenantId);
   List<Tenant> getTenantsByUser(User user);
}
