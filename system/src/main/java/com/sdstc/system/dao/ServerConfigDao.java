package com.sdstc.system.dao;

import com.sdstc.system.dao.base.ServerConfigBaseDao;
import com.sdstc.system.model.ServerConfig;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface ServerConfigDao extends ServerConfigBaseDao{
   List<ServerConfig> selectByDto(ServerConfig dto);
   Integer selectCountByDto(ServerConfig dto);
   List<ServerConfig> selectPageByDto(@Param("dto")ServerConfig dto,@Param("pageDto")PageDto pageDto);
}
