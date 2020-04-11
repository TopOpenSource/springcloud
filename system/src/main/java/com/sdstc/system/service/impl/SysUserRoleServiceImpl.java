package com.sdstc.system.service.impl;

import com.sdstc.pub.oauth.service.Snowflake;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.SysUserRoleDao;
import com.sdstc.system.model.SysUserRole;
import com.sdstc.system.service.SysUserRoleService;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
/**
 * 
 * @author 
 *
 */
@Service("sysUserRoleService")
@Log4j2
public class SysUserRoleServiceImpl implements SysUserRoleService{
    @Autowired
    private Snowflake snowflake;
    
    @Autowired
	private SysUserRoleDao sysUserRoleDao;
    
	@Override
	public void insert(SysUserRole dto) {
	    Date now=new Date();
	    dto.setId(snowflake.getId());
	    dto.setGmtCreate(now);
	    
		sysUserRoleDao.insert(dto);
	}

	@Override
	public void updateByPK(SysUserRole dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysUserRoleDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(SysUserRole dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysUserRoleDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id,Long customerId) {
		sysUserRoleDao.deleteByPK(id,customerId);
	}

	@Override
	public SysUserRole selectByPK(Long id,Long customerId) {
		return sysUserRoleDao.selectByPK(id,customerId);
	}

	@Override
	public List<SysUserRole> selectByDto(SysUserRole dto) {
		return sysUserRoleDao.selectByDto(dto);
	}

    @Override
	public PageResult<SysUserRole> selectPageByDto(SysUserRole dto, PageDto pageDto) {
	    pageDto.setCount(sysUserRoleDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			List<SysUserRole> results=sysUserRoleDao.selectPageByDto(dto, pageDto);
			return new PageResult<SysUserRole>(pageDto, results);
		}else {
			return new PageResult<SysUserRole>(pageDto, null);
		}
	}

	@Override
	public void insertBatch(List<SysUserRole> dtos) {
		sysUserRoleDao.insertBatch(dtos);		
	}
}
