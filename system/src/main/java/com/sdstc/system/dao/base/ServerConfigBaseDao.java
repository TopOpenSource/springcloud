package com.sdstc.system.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.system.model.ServerConfig;


public interface ServerConfigBaseDao {
   void  insert(ServerConfig dto);
   void  updateByPK(ServerConfig dto);
   void  updateSelectiveByPK(ServerConfig dto);
   void  deleteByPK(@Param("id") Long id);
   ServerConfig  selectByPK(@Param("id") Long id);
   
}
