package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.SysUserOrg;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
/**
 * 
 * @author
 *
 */
public interface SysUserOrgService {
	void insert(SysUserOrg dto);

	void updateByPK(SysUserOrg dto);

	void updateSelectiveByPK(SysUserOrg dto);

	void deleteByPK(Long id,Long customerId);

	SysUserOrg selectByPK(Long id,Long customerId);

	List<SysUserOrg> selectByDto(SysUserOrg dto);
	
	PageResult<SysUserOrg> selectPageByDto(SysUserOrg dto,PageDto pageDto);
}
