package com.sdstc.system.service;

import java.util.List;

import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import com.sdstc.system.model.SysUserExt;
import com.sdstc.system.model.UserInfo;
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
	
	SysUserExt selectByUserDto(UserInfo dto);
	
	PageResult<SysUserExt> selectPageByDto(SysUserExt dto,PageDto pageDto);
	
	/**
	 * 根据用户账户更新信息
	 * @param dto
	 */
	void  updateSelectiveByUserAccount(SysUserExt dto);
	
	/**
	 * 更新登录失败信息
	 * @param dto
	 */
	void  updateLoginFaildInfo(String userAccount);
}
