package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.SysUserExt;
import com.sdstc.pub.dto.PageDto;
/**
 * 
 * @author
 *
 */
public interface SysUserExtService {
	void insert(SysUserExt dto);

	void updateByPK(SysUserExt dto);

	void updateSelectiveByPK(SysUserExt dto);

	void deleteByPK(Long id);

	SysUserExt selectByPK(Long id);

	List<SysUserExt> selectByDto(SysUserExt dto);
	
	List<SysUserExt> selectPageByDto(SysUserExt dto,PageDto pageDto);
}
