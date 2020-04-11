package com.sdstc.system.dao;

import com.sdstc.system.dao.base.SysCustomerBaseDao;
import com.sdstc.system.model.Customer;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface SysCustomerDao extends SysCustomerBaseDao{
   List<Customer> selectByDto(Customer dto);
   Integer selectCountByDto(Customer dto);
   List<Customer> selectPageByDto(@Param("dto") Customer dto, @Param("pageDto")PageDto pageDto);
}
