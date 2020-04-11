package com.sdstc.system.dao;

import com.sdstc.system.dao.base.SysUserBaseDao;
import com.sdstc.system.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface SysUserDao extends SysUserBaseDao{
   List<User> selectByDto(User dto);
   Integer selectCountByDto(User dto);
   List<User> selectPageByDto(@Param("dto") User dto, @Param("pageDto")PageDto pageDto);
}
