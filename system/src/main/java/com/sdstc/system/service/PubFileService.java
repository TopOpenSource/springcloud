package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.PubFile;
import com.sdstc.pub.dto.PageDto;
/**
 * 
 * @author
 *
 */
public interface PubFileService {
	void insert(PubFile dto);

	void updateByPK(PubFile dto);

	void updateSelectiveByPK(PubFile dto);

	void deleteByPK(Long id,Long customerId);

	PubFile selectByPK(Long id,Long customerId);

	List<PubFile> selectByDto(PubFile dto);
	
	List<PubFile> selectPageByDto(PubFile dto,PageDto pageDto);
}
