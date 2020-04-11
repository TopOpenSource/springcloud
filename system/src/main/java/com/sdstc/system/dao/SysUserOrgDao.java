package com.sdstc.system.dao;

import com.sdstc.system.dao.base.SysUserOrgBaseDao;
import com.sdstc.system.model.UserOrg;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface SysUserOrgDao extends SysUserOrgBaseDao{
   List<UserOrg> selectByDto(UserOrg dto);
   Integer selectCountByDto(UserOrg dto);
   List<UserOrg> selectPageByDto(@Param("dto") UserOrg dto, @Param("pageDto")PageDto pageDto);
}
