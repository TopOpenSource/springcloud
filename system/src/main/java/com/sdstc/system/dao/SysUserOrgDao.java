package com.sdstc.system.dao;

import com.sdstc.system.dao.base.SysUserOrgBaseDao;
import com.sdstc.system.model.SysUserOrg;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface SysUserOrgDao extends SysUserOrgBaseDao{
   List<SysUserOrg> selectByDto(SysUserOrg dto);
   Integer selectCountByDto(SysUserOrg dto);
   List<SysUserOrg> selectPageByDto(@Param("dto")SysUserOrg dto,@Param("pageDto")PageDto pageDto);
}
