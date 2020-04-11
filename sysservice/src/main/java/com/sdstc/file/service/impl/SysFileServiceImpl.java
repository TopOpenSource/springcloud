package com.sdstc.file.service.impl;

import com.sdstc.pub.oauth.service.Snowflake;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.file.dao.SysFileDao;
import com.sdstc.file.model.SysFile;
import com.sdstc.file.service.SysFileService;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
/**
 * 
 * @author 
 *
 */
@Service("sysFileService")
@Log4j2
public class SysFileServiceImpl implements SysFileService{
    @Autowired
    private Snowflake snowflake;
    
    @Autowired
	private SysFileDao sysFileDao;
    
	@Override
	public void insert(SysFile dto) {
	    Date now=new Date();
	    dto.setId(snowflake.getId());
	    dto.setGmtCreate(now);
	    
		sysFileDao.insert(dto);
	}

	@Override
	public void updateByPK(SysFile dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysFileDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(SysFile dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysFileDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id,Long customerId) {
		sysFileDao.deleteByPK(id,customerId);
	}

	@Override
	public SysFile selectByPK(Long id,Long customerId) {
		return sysFileDao.selectByPK(id,customerId);
	}

	@Override
	public List<SysFile> selectByDto(SysFile dto) {
		return sysFileDao.selectByDto(dto);
	}

    @Override
	public PageResult<SysFile> selectPageByDto(SysFile dto, PageDto pageDto) {
	    pageDto.setCount(sysFileDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			List<SysFile> results=sysFileDao.selectPageByDto(dto, pageDto);
			return new PageResult<SysFile>(pageDto, results);
		}else {
			return new PageResult<SysFile>(pageDto, null);
		}
	}
}
