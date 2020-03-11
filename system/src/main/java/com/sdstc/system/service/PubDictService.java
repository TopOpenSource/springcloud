package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.PubDict;
import com.sdstc.pub.dto.PageDto;
/**
 * 
 * @author
 *
 */
public interface PubDictService {
	void insert(PubDict dto);

	void updateByPK(PubDict dto);

	void updateSelectiveByPK(PubDict dto);

	void deleteByPK(Long id);

	PubDict selectByPK(Long id);

	List<PubDict> selectByDto(PubDict dto);
	
	List<PubDict> selectPageByDto(PubDict dto,PageDto pageDto);
}
