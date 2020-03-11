package ${serviceInterPackage};

import java.util.List;
import ${modelPackage}.${entityName};
<#if pkJavaType=="Date" || tenantKeyJavaType=="Date">
import java.util.Date;
<#elseif pkJavaType=="BigDecimal" || tenantKeyJavaType=="BigDecimal">
import java.math.BigDecimal;
</#if>
/**
 * 
 * @author
 *
 */
public interface ${entityName}Service {
	void insert(${entityName} dto);

	void updateByPK(${entityName} dto);

	void updateSelectiveByPK(${entityName} dto);

	void deleteByPK(${pkJavaType} ${primaryKey}<#if hasTenant?string("true","false")== "true">,${tenantKeyJavaType} ${tenantKey}</#if>);

	${entityName} selectByPK(${pkJavaType} ${primaryKey}<#if hasTenant?string("true","false")== "true">,${tenantKeyJavaType} ${tenantKey}</#if>);

	List<${entityName}> selectByDto(${entityName} dto);
}