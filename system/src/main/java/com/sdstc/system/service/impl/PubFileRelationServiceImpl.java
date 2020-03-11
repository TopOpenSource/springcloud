package com.sdstc.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.PubFileRelationDao;
import com.sdstc.system.model.PubFileRelation;
import com.sdstc.system.service.PubFileRelationService;
import com.sdstc.pub.dto.PageDto;

/**
 * 
 * @author 
 *
 */
@Service("pubFileRelationService")
public class PubFileRelationServiceImpl implements PubFileRelationService{
    @Autowired
	private PubFileRelationDao pubFileRelationDao;
    
	@Override
	public void insert(PubFileRelation dto) {
		pubFileRelationDao.insert(dto);
	}

	@Override
	public void updateByPK(PubFileRelation dto) {
		pubFileRelationDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(PubFileRelation dto) {
		pubFileRelationDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id,Long customerId) {
		pubFileRelationDao.deleteByPK(id,customerId);
	}

	@Override
	public PubFileRelation selectByPK(Long id,Long customerId) {
		return pubFileRelationDao.selectByPK(id,customerId);
	}

	@Override
	public List<PubFileRelation> selectByDto(PubFileRelation dto) {
		return pubFileRelationDao.selectByDto(dto);
	}

    @Override
	public List<PubFileRelation> selectPageByDto(PubFileRelation dto, PageDto pageDto) {
		pageDto.setCount(pubFileRelationDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			return pubFileRelationDao.selectPageByDto(dto, pageDto);
		}else {
			return null;
		}
	}
}
