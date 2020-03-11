package com.sdstc.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.SysRoleDao;
import com.sdstc.system.model.SysRole;
import com.sdstc.system.service.SysRoleService;
import com.sdstc.pub.dto.PageDto;

/**
 * 
 * @author 
 *
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService{
    @Autowired
	private SysRoleDao sysRoleDao;
    
	@Override
	public void insert(SysRole dto) {
		sysRoleDao.insert(dto);
	}

	@Override
	public void updateByPK(SysRole dto) {
		sysRoleDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(SysRole dto) {
		sysRoleDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id) {
		sysRoleDao.deleteByPK(id);
	}

	@Override
	public SysRole selectByPK(Long id) {
		return sysRoleDao.selectByPK(id);
	}

	@Override
	public List<SysRole> selectByDto(SysRole dto) {
		return sysRoleDao.selectByDto(dto);
	}

    @Override
	public List<SysRole> selectPageByDto(SysRole dto, PageDto pageDto) {
		pageDto.setCount(sysRoleDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			return sysRoleDao.selectPageByDto(dto, pageDto);
		}else {
			return null;
		}
	}
}
