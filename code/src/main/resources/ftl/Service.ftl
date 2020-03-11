package ${servicePackage};

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${daoPackage}.${entityName}Dao;
import ${modelPackage}.${entityName};
import ${serviceInterPackage}.${entityName}Service;

/**
 * 
 * @author 
 *
 */
@Service("pubFileService")
public class ${entityName}ServiceImpl implements ${entityName}Service{
    @Autowired
	private ${entityName}Dao ${entityNameLowerCase}Dao;
    
	@Override
	public void insert(${entityName} dto) {
		${entityNameLowerCase}Dao.insert(dto);
	}

	@Override
	public void updateByPK(${entityName} dto) {
		${entityNameLowerCase}Dao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(${entityName} dto) {
		${entityNameLowerCase}Dao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(${pkJavaType} ${primaryKey}<#if hasTenant?string("true","false")== "true">,${tenantKeyJavaType} ${tenantKey}</#if>) {
		${entityNameLowerCase}Dao.deleteByPK(${primaryKey}<#if hasTenant?string("true","false")== "true">,${tenantKey}</#if>);
	}

	@Override
	public ${entityName} selectByPK(${pkJavaType} ${primaryKey}<#if hasTenant?string("true","false")== "true">,${tenantKeyJavaType} ${tenantKey}</#if>) {
		return ${entityNameLowerCase}Dao.selectByPK(${primaryKey}<#if hasTenant?string("true","false")== "true">,${tenantKey}</#if>);
	}

	@Override
	public List<${entityName}> selectByDto(${entityName} dto) {
		return ${entityNameLowerCase}Dao.selectByDto(dto);
	}

}
