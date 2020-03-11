package ${controllerPackage};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.ResultDto;
import ${modelPackage}.${entityName};
import ${serviceInterPackage}.${entityName}Service;

@RestController
@RequestMapping("/api/${serviceName}/${entityNameLowerCase}")
public class ${entityName}Controller {
	@Autowired
	private ${entityName}Service ${entityNameLowerCase}Service;
	
	@RequestMapping("insert")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(${entityName} dto) {
		ResultDto resultDto=new ResultDto(1,"");
		${entityNameLowerCase}Service.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(${entityName} dto) {
		ResultDto resultDto=new ResultDto(1,"");
		${entityNameLowerCase}Service.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(${entityName} dto) {
		ResultDto resultDto=new ResultDto(1,"");
		${entityNameLowerCase}Service.updateSelectiveByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("deleteByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto deleteByPK(Long id) {
		ResultDto resultDto=new ResultDto(1,"");
		${entityNameLowerCase}Service.deleteByPK(id);
		return resultDto;
	}
	
	@RequestMapping("selectByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ${entityName} selectByPK(Long id) {
		return ${entityNameLowerCase}Service.selectByPK(id);
	}
	
	@RequestMapping("selectByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public List<${entityName}> selectByDto(${entityName} dto) {
		return ${entityNameLowerCase}Service.selectByDto(dto);
	}
	
	@RequestMapping("selectPageByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public List<${entityName}> selectPageByDto(${entityName} dto,PageDto pageDto) {
		return ${entityNameLowerCase}Service.selectPageByDto(dto,pageDto);
	}
}
