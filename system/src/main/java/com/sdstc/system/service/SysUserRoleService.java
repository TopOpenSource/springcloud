package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.SysUserRole;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
/**
 * 
 * @author
 *
 */
public interface SysUserRoleService {
	void insert(SysUserRole dto);

	void updateByPK(SysUserRole dto);

	void updateSelectiveByPK(SysUserRole dto);

	void deleteByPK(Long id,Long customerId);

	SysUserRole selectByPK(Long id,Long customerId);

	List<SysUserRole> selectByDto(SysUserRole dto);
	
	PageResult<SysUserRole> selectPageByDto(SysUserRole dto,PageDto pageDto);
	
	void insertBatch(List<SysUserRole> dtos);
}
