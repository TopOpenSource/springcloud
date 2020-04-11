package com.sdstc.system.service.impl;

import com.sdstc.pub.oauth.service.Snowflake;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.SysUserOrgDao;
import com.sdstc.system.model.SysUserOrg;
import com.sdstc.system.service.SysUserOrgService;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
/**
 * 
 * @author 
 *
 */
@Service("sysUserOrgService")
@Log4j2
public class SysUserOrgServiceImpl implements SysUserOrgService{
    @Autowired
    private Snowflake snowflake;
    
    @Autowired
	private SysUserOrgDao sysUserOrgDao;
    
	@Override
	public void insert(SysUserOrg dto) {
	    Date now=new Date();
	    dto.setId(snowflake.getId());
	    dto.setGmtCreate(now);
	    
		sysUserOrgDao.insert(dto);
	}

	@Override
	public void updateByPK(SysUserOrg dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysUserOrgDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(SysUserOrg dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysUserOrgDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id,Long customerId) {
		sysUserOrgDao.deleteByPK(id,customerId);
	}

	@Override
	public SysUserOrg selectByPK(Long id,Long customerId) {
		return sysUserOrgDao.selectByPK(id,customerId);
	}

	@Override
	public List<SysUserOrg> selectByDto(SysUserOrg dto) {
		return sysUserOrgDao.selectByDto(dto);
	}

    @Override
	public PageResult<SysUserOrg> selectPageByDto(SysUserOrg dto, PageDto pageDto) {
	    pageDto.setCount(sysUserOrgDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			List<SysUserOrg> results=sysUserOrgDao.selectPageByDto(dto, pageDto);
			return new PageResult<SysUserOrg>(pageDto, results);
		}else {
			return new PageResult<SysUserOrg>(pageDto, null);
		}
	}
}
