package com.sdstc.system.dao;

import com.sdstc.system.dao.base.SysCustomerBaseDao;
import com.sdstc.system.model.SysCustomer;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface SysCustomerDao extends SysCustomerBaseDao{
   List<SysCustomer> selectByDto(SysCustomer dto);
   Integer selectCountByDto(SysCustomer dto);
   List<SysCustomer> selectPageByDto(@Param("dto")SysCustomer dto,@Param("pageDto")PageDto pageDto);
}
