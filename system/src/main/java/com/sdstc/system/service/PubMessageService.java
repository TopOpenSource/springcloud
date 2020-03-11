package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.PubMessage;
import com.sdstc.pub.dto.PageDto;
/**
 * 
 * @author
 *
 */
public interface PubMessageService {
	void insert(PubMessage dto);

	void updateByPK(PubMessage dto);

	void updateSelectiveByPK(PubMessage dto);

	void deleteByPK(Long id,Long customerId);

	PubMessage selectByPK(Long id,Long customerId);

	List<PubMessage> selectByDto(PubMessage dto);
	
	List<PubMessage> selectPageByDto(PubMessage dto,PageDto pageDto);
}
