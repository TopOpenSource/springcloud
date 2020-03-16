package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.SysDict;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
/**
 * 
 * @author
 *
 */
public interface SysDictService {
	void insert(SysDict dto);

	void updateByPK(SysDict dto);

	void updateSelectiveByPK(SysDict dto);

	void deleteByPK(Long id);

	SysDict selectByPK(Long id);

	List<SysDict> selectByDto(SysDict dto);
	
	PageResult<SysDict> selectPageByDto(SysDict dto,PageDto pageDto);
}
