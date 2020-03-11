package com.sdstc.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.PubMessageDao;
import com.sdstc.system.model.PubMessage;
import com.sdstc.system.service.PubMessageService;
import com.sdstc.pub.dto.PageDto;

/**
 * 
 * @author 
 *
 */
@Service("pubMessageService")
public class PubMessageServiceImpl implements PubMessageService{
    @Autowired
	private PubMessageDao pubMessageDao;
    
	@Override
	public void insert(PubMessage dto) {
		pubMessageDao.insert(dto);
	}

	@Override
	public void updateByPK(PubMessage dto) {
		pubMessageDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(PubMessage dto) {
		pubMessageDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id,Long customerId) {
		pubMessageDao.deleteByPK(id,customerId);
	}

	@Override
	public PubMessage selectByPK(Long id,Long customerId) {
		return pubMessageDao.selectByPK(id,customerId);
	}

	@Override
	public List<PubMessage> selectByDto(PubMessage dto) {
		return pubMessageDao.selectByDto(dto);
	}

    @Override
	public List<PubMessage> selectPageByDto(PubMessage dto, PageDto pageDto) {
		pageDto.setCount(pubMessageDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			return pubMessageDao.selectPageByDto(dto, pageDto);
		}else {
			return null;
		}
	}
}
