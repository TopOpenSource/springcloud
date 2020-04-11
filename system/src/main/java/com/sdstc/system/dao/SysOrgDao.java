package com.sdstc.system.dao;

import com.sdstc.system.dao.base.SysOrgBaseDao;
import com.sdstc.system.model.Org;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface SysOrgDao extends SysOrgBaseDao{
   List<Org> selectByDto(Org dto);
   Integer selectCountByDto(Org dto);
   List<Org> selectPageByDto(@Param("dto") Org dto, @Param("pageDto")PageDto pageDto);
}
