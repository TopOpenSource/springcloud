package com.sdstc.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.system.model.SysDict;
import com.sdstc.oauth.service.Oauth2Service;
import com.sdstc.system.service.SysDictService;
import com.sdstc.pub.dto.LoginUserInfo;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/system/sysDict")
@Log4j2
public class SysDictController {
	@Autowired
	private SysDictService sysDictService;
	@Autowired
	private  Oauth2Service oauth2Service;
	
	@RequestMapping("insert")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(SysDict dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setCreateAccount(loginUser.getUserAccount());
		
		sysDictService.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(SysDict dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysDictService.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(SysDict dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysDictService.updateSelectiveByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("deleteByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto deleteByPK(Long id) {
		ResultDto resultDto=new ResultDto(1,"");
		sysDictService.deleteByPK(id);
		return resultDto;
	}
	
	@RequestMapping("selectByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public SysDict selectByPK(Long id) {
		return sysDictService.selectByPK(id);
	}
	
	@RequestMapping("selectByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public List<SysDict> selectByDto(SysDict dto) {
		return sysDictService.selectByDto(dto);
	}
	
	@RequestMapping("selectPageByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public PageResult<SysDict> selectPageByDto(SysDict dto,PageDto pageDto) {
		return sysDictService.selectPageByDto(dto,pageDto);
	}
}
