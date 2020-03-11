package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.PubFile;
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
}
