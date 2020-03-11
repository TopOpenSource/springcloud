package com.sdstc.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.PubDictDao;
import com.sdstc.system.model.PubDict;
import com.sdstc.system.service.PubDictService;
import com.sdstc.pub.dto.PageDto;

/**
 * 
 * @author 
 *
 */
@Service("pubDictService")
public class PubDictServiceImpl implements PubDictService{
    @Autowired
	private PubDictDao pubDictDao;
    
	@Override
	public void insert(PubDict dto) {
		pubDictDao.insert(dto);
	}

	@Override
	public void updateByPK(PubDict dto) {
		pubDictDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(PubDict dto) {
		pubDictDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id) {
		pubDictDao.deleteByPK(id);
	}

	@Override
	public PubDict selectByPK(Long id) {
		return pubDictDao.selectByPK(id);
	}

	@Override
	public List<PubDict> selectByDto(PubDict dto) {
		return pubDictDao.selectByDto(dto);
	}

    @Override
	public List<PubDict> selectPageByDto(PubDict dto, PageDto pageDto) {
		pageDto.setCount(pubDictDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			return pubDictDao.selectPageByDto(dto, pageDto);
		}else {
			return null;
		}
	}
}
