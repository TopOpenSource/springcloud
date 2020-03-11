package com.sdstc.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.SysUserExtDao;
import com.sdstc.system.model.SysUserExt;
import com.sdstc.system.service.SysUserExtService;
import com.sdstc.pub.dto.PageDto;

/**
 * 
 * @author 
 *
 */
@Service("sysUserExtService")
public class SysUserExtServiceImpl implements SysUserExtService{
    @Autowired
	private SysUserExtDao sysUserExtDao;
    
	@Override
	public void insert(SysUserExt dto) {
		sysUserExtDao.insert(dto);
	}

	@Override
	public void updateByPK(SysUserExt dto) {
		sysUserExtDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(SysUserExt dto) {
		sysUserExtDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id) {
		sysUserExtDao.deleteByPK(id);
	}

	@Override
	public SysUserExt selectByPK(Long id) {
		return sysUserExtDao.selectByPK(id);
	}

	@Override
	public List<SysUserExt> selectByDto(SysUserExt dto) {
		return sysUserExtDao.selectByDto(dto);
	}

    @Override
	public List<SysUserExt> selectPageByDto(SysUserExt dto, PageDto pageDto) {
		pageDto.setCount(sysUserExtDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			return sysUserExtDao.selectPageByDto(dto, pageDto);
		}else {
			return null;
		}
	}
}
