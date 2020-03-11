package com.sdstc.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.ServerConfigDao;
import com.sdstc.system.model.ServerConfig;
import com.sdstc.system.service.ServerConfigService;
import com.sdstc.pub.dto.PageDto;

/**
 * 
 * @author 
 *
 */
@Service("serverConfigService")
public class ServerConfigServiceImpl implements ServerConfigService{
    @Autowired
	private ServerConfigDao serverConfigDao;
    
	@Override
	public void insert(ServerConfig dto) {
		serverConfigDao.insert(dto);
	}

	@Override
	public void updateByPK(ServerConfig dto) {
		serverConfigDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(ServerConfig dto) {
		serverConfigDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id) {
		serverConfigDao.deleteByPK(id);
	}

	@Override
	public ServerConfig selectByPK(Long id) {
		return serverConfigDao.selectByPK(id);
	}

	@Override
	public List<ServerConfig> selectByDto(ServerConfig dto) {
		return serverConfigDao.selectByDto(dto);
	}

    @Override
	public List<ServerConfig> selectPageByDto(ServerConfig dto, PageDto pageDto) {
		pageDto.setCount(serverConfigDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			return serverConfigDao.selectPageByDto(dto, pageDto);
		}else {
			return null;
		}
	}
}
