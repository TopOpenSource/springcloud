package com.sdstc.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.PubLogDao;
import com.sdstc.system.model.PubLog;
import com.sdstc.system.service.PubLogService;
import com.sdstc.pub.dto.PageDto;

/**
 * 
 * @author 
 *
 */
@Service("pubLogService")
public class PubLogServiceImpl implements PubLogService{
    @Autowired
	private PubLogDao pubLogDao;
    
	@Override
	public void insert(PubLog dto) {
		pubLogDao.insert(dto);
	}

	@Override
	public void updateByPK(PubLog dto) {
		pubLogDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(PubLog dto) {
		pubLogDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id,Long customerId) {
		pubLogDao.deleteByPK(id,customerId);
	}

	@Override
	public PubLog selectByPK(Long id,Long customerId) {
		return pubLogDao.selectByPK(id,customerId);
	}

	@Override
	public List<PubLog> selectByDto(PubLog dto) {
		return pubLogDao.selectByDto(dto);
	}

    @Override
	public List<PubLog> selectPageByDto(PubLog dto, PageDto pageDto) {
		pageDto.setCount(pubLogDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			return pubLogDao.selectPageByDto(dto, pageDto);
		}else {
			return null;
		}
	}
}
