package com.sdstc.system.service.impl;

import com.sdstc.oauth.service.Snowflake;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.PubFileDao;
import com.sdstc.system.model.PubFile;
import com.sdstc.system.service.PubFileService;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
/**
 * 
 * @author 
 *
 */
@Service("pubFileService")
@Log4j2
public class PubFileServiceImpl implements PubFileService{
    @Autowired
    private Snowflake snowflake;
    
    @Autowired
	private PubFileDao pubFileDao;
    
	@Override
	public void insert(PubFile dto) {
	    Date now=new Date();
	    dto.setId(snowflake.getId());
	    dto.setGmtCreate(now);
	    
		pubFileDao.insert(dto);
	}

	@Override
	public void updateByPK(PubFile dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		pubFileDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(PubFile dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
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

    @Override
	public PageResult<PubFile> selectPageByDto(PubFile dto, PageDto pageDto) {
	    pageDto.setCount(pubFileDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			List<PubFile> results=pubFileDao.selectPageByDto(dto, pageDto);
			return new PageResult<PubFile>(pageDto, results);
		}else {
			return new PageResult<PubFile>(pageDto, null);
		}
	}
}
