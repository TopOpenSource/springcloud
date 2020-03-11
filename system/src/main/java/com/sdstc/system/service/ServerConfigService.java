package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.ServerConfig;
import com.sdstc.pub.dto.PageDto;
/**
 * 
 * @author
 *
 */
public interface ServerConfigService {
	void insert(ServerConfig dto);

	void updateByPK(ServerConfig dto);

	void updateSelectiveByPK(ServerConfig dto);

	void deleteByPK(Long id);

	ServerConfig selectByPK(Long id);

	List<ServerConfig> selectByDto(ServerConfig dto);
	
	List<ServerConfig> selectPageByDto(ServerConfig dto,PageDto pageDto);
}
