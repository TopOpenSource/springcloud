package com.sdstc.system.dao;

import com.sdstc.system.dao.base.SysUserExtBaseDao;
import com.sdstc.system.model.SysUserExt;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface SysUserExtDao extends SysUserExtBaseDao{
   List<SysUserExt> selectByDto(SysUserExt dto);
   Integer selectCountByDto(SysUserExt dto);
   List<SysUserExt> selectPageByDto(@Param("dto")SysUserExt dto,@Param("pageDto")PageDto pageDto);
}
