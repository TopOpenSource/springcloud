package com.sdstc.project.service;

import java.util.List;
import com.sdstc.project.model.TestProject;
import com.sdstc.pub.dto.PageDto;
/**
 * 
 * @author
 *
 */
public interface TestProjectService {
	void insert(TestProject dto);

	void updateByPK(TestProject dto);

	void updateSelectiveByPK(TestProject dto);

	void deleteByPK(Long id,Long customerId);

	TestProject selectByPK(Long id,Long customerId);

	List<TestProject> selectByDto(TestProject dto);
	
	List<TestProject> selectPageByDto(TestProject dto,PageDto pageDto);
}
