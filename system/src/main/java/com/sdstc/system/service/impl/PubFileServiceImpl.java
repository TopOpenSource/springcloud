package com.sdstc.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.PubFileDao;
import com.sdstc.system.model.PubFile;
import com.sdstc.system.service.PubFileService;

/**
 * 
 * @author 
 *
 */
@Service("pubFileService")
public class PubFileServiceImpl implements PubFileService{
    @Autowired
	private PubFileDao pubFileDao;
    
	@Override
	public void insert(PubFile dto) {
		pubFileDao.insert(dto);
	}

	@Override
	public void updateByPK(PubFile dto) {
		pubFileDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(PubFile dto) {
		pubFileDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id,Long customerId) {
		pubFileDao.deleteByPK(id,customerId);
	}

	@Override
	public PubFile selectByPK(Long id,Long customerId) {
		return pubFileDao.selectByPK(id,customerId);
	}

	@Override
	public List<PubFile> selectByDto(PubFile dto) {
		return pubFileDao.selectByDto(dto);
	}

}
