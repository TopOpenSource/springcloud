package com.sdstc.system.service.impl;

import com.sdstc.pub.oauth.service.Snowflake;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.SysOrgDao;
import com.sdstc.system.model.SysOrg;
import com.sdstc.system.service.SysOrgService;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
/**
 * 
 * @author 
 *
 */
@Service("sysOrgService")
@Log4j2
public class SysOrgServiceImpl implements SysOrgService{
    @Autowired
    private Snowflake snowflake;
    
    @Autowired
	private SysOrgDao sysOrgDao;
    
	@Override
	public void insert(SysOrg dto) {
	    Date now=new Date();
	    dto.setId(snowflake.getId());
	    dto.setGmtCreate(now);
	    
		sysOrgDao.insert(dto);
	}

	@Override
	public void updateByPK(SysOrg dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysOrgDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(SysOrg dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysOrgDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id,Long customerId) {
		sysOrgDao.deleteByPK(id,customerId);
	}

	@Override
	public SysOrg selectByPK(Long id,Long customerId) {
		return sysOrgDao.selectByPK(id,customerId);
	}

	@Override
	public List<SysOrg> selectByDto(SysOrg dto) {
		return sysOrgDao.selectByDto(dto);
	}

    @Override
	public PageResult<SysOrg> selectPageByDto(SysOrg dto, PageDto pageDto) {
	    pageDto.setCount(sysOrgDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			List<SysOrg> results=sysOrgDao.selectPageByDto(dto, pageDto);
			return new PageResult<SysOrg>(pageDto, results);
		}else {
			return new PageResult<SysOrg>(pageDto, null);
		}
	}
}
