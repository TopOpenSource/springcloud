package com.sdstc.system.service.impl;

import com.sdstc.oauth.service.Snowflake;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.SysDictDao;
import com.sdstc.system.model.SysDict;
import com.sdstc.system.service.SysDictService;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
/**
 * 
 * @author 
 *
 */
@Service("sysDictService")
@Log4j2
public class SysDictServiceImpl implements SysDictService{
    @Autowired
    private Snowflake snowflake;
    
    @Autowired
	private SysDictDao sysDictDao;
    
	@Override
	public void insert(SysDict dto) {
	    Date now=new Date();
	    dto.setId(snowflake.getId());
	    dto.setGmtCreate(now);
	    
	    dto.setPath(dto.getPPath()+"/"+dto.getCode());
		sysDictDao.insert(dto);
	}

	@Override
	public void updateByPK(SysDict dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		if(dto.getPPath()!=null) {
			dto.setPath(dto.getPPath()+"/"+dto.getCode());
		}
		
		sysDictDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(SysDict dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		if(dto.getPPath()!=null) {
			dto.setPath(dto.getPPath()+"/"+dto.getCode());
		}
		
		sysDictDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id) {
		sysDictDao.deleteByPK(id);
	}

	@Override
	public SysDict selectByPK(Long id) {
		return sysDictDao.selectByPK(id);
	}

	@Override
	public List<SysDict> selectByDto(SysDict dto) {
		return sysDictDao.selectByDto(dto);
	}

    @Override
	public PageResult<SysDict> selectPageByDto(SysDict dto, PageDto pageDto) {
	    pageDto.setCount(sysDictDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			List<SysDict> results=sysDictDao.selectPageByDto(dto, pageDto);
			return new PageResult<SysDict>(pageDto, results);
		}else {
			return new PageResult<SysDict>(pageDto, null);
		}
	}
}
