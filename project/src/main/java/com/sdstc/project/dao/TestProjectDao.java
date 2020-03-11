package com.sdstc.project.dao;

import com.sdstc.project.dao.base.TestProjectBaseDao;
import com.sdstc.project.model.TestProject;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface TestProjectDao extends TestProjectBaseDao{
   List<TestProject> selectByDto(TestProject dto);
   Integer selectCountByDto(TestProject dto);
   List<TestProject> selectPageByDto(@Param("dto")TestProject dto,@Param("pageDto")PageDto pageDto);
}
