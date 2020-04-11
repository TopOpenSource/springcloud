package com.sdstc.file.service;

import java.util.List;
import com.sdstc.file.model.SysFile;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
/**
 * 
 * @author
 *
 */
public interface SysFileService {
	void insert(SysFile dto);

	void updateByPK(SysFile dto);

	void updateSelectiveByPK(SysFile dto);

	void deleteByPK(Long id,Long customerId);

	SysFile selectByPK(Long id,Long customerId);

	List<SysFile> selectByDto(SysFile dto);
	
	PageResult<SysFile> selectPageByDto(SysFile dto,PageDto pageDto);
}
