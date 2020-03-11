package com.sdstc.project.dao.base;


import org.apache.ibatis.annotations.Param;
import com.sdstc.project.model.TestProject;


public interface TestProjectBaseDao {
   void  insert(TestProject dto);
   void  updateByPK(TestProject dto);
   void  updateSelectiveByPK(TestProject dto);
   void  deleteByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   TestProject  selectByPK(@Param("id") Long id,@Param("customerId") Long customerId);
   
}
