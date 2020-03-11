package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.SysRole;
import com.sdstc.pub.dto.PageDto;
/**
 * 
 * @author
 *
 */
public interface SysRoleService {
	void insert(SysRole dto);

	void updateByPK(SysRole dto);

	void updateSelectiveByPK(SysRole dto);

	void deleteByPK(Long id);

	SysRole selectByPK(Long id);

	List<SysRole> selectByDto(SysRole dto);
	
	List<SysRole> selectPageByDto(SysRole dto,PageDto pageDto);
}
