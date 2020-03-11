package com.sdstc.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.project.dao.TestProjectDao;
import com.sdstc.project.model.TestProject;
import com.sdstc.project.service.TestProjectService;
import com.sdstc.pub.dto.PageDto;

/**
 * 
 * @author 
 *
 */
@Service("testProjectService")
public class TestProjectServiceImpl implements TestProjectService{
    @Autowired
	private TestProjectDao testProjectDao;
    
	@Override
	public void insert(TestProject dto) {
		testProjectDao.insert(dto);
	}

	@Override
	public void updateByPK(TestProject dto) {
		testProjectDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(TestProject dto) {
		testProjectDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id,Long customerId) {
		testProjectDao.deleteByPK(id,customerId);
	}

	@Override
	public TestProject selectByPK(Long id,Long customerId) {
		return testProjectDao.selectByPK(id,customerId);
	}

	@Override
	public List<TestProject> selectByDto(TestProject dto) {
		return testProjectDao.selectByDto(dto);
	}

    @Override
	public List<TestProject> selectPageByDto(TestProject dto, PageDto pageDto) {
		pageDto.setCount(testProjectDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			return testProjectDao.selectPageByDto(dto, pageDto);
		}else {
			return null;
		}
	}
}
