package com.sdstc.system.dao;

import com.sdstc.system.dao.base.PubLogBaseDao;
import com.sdstc.system.model.PubLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface PubLogDao extends PubLogBaseDao{
   List<PubLog> selectByDto(PubLog dto);
   Integer selectCountByDto(PubLog dto);
   List<PubLog> selectPageByDto(@Param("dto")PubLog dto,@Param("pageDto")PageDto pageDto);
}
