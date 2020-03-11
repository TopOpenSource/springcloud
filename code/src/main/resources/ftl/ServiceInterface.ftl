package ${daoPackage};

import java.util.List;
import ${modelPackage}.${entityName};

public interface CustomerDao {
   void  insert(${entityName} dto);
   void  updateByPK(${entityName} dto);
   void  updateSelectiveByPK(${entityName} dto);
   void  deleteByPK(@Param("id") Long id,@Param("id") Long id);
   ${entityName}  selectByPK(@Param("id") Long id,@Param("id") Long id);
   List<${entityName}> selectByDto(${entityName} dto);
   
}
