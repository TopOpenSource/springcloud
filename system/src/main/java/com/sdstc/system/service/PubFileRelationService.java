package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.PubFileRelation;
import com.sdstc.pub.dto.PageDto;
/**
 * 
 * @author
 *
 */
public interface PubFileRelationService {
	void insert(PubFileRelation dto);

	void updateByPK(PubFileRelation dto);

	void updateSelectiveByPK(PubFileRelation dto);

	void deleteByPK(Long id,Long customerId);

	PubFileRelation selectByPK(Long id,Long customerId);

	List<PubFileRelation> selectByDto(PubFileRelation dto);
	
	List<PubFileRelation> selectPageByDto(PubFileRelation dto,PageDto pageDto);
}
