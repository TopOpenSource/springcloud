package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.PubLog;
import com.sdstc.pub.dto.PageDto;
/**
 * 
 * @author
 *
 */
public interface PubLogService {
	void insert(PubLog dto);

	void updateByPK(PubLog dto);

	void updateSelectiveByPK(PubLog dto);

	void deleteByPK(Long id,Long customerId);

	PubLog selectByPK(Long id,Long customerId);

	List<PubLog> selectByDto(PubLog dto);
	
	List<PubLog> selectPageByDto(PubLog dto,PageDto pageDto);
}
