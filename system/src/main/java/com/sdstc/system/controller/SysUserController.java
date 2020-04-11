package com.sdstc.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.system.model.SysUser;
import com.sdstc.pub.oauth.service.Oauth2Service;
import com.sdstc.system.service.SysUserService;
import com.sdstc.pub.dto.LoginUserInfo;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/system/sysUser")
@Log4j2
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private  Oauth2Service oauth2Service;
	
	@RequestMapping("insert")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(SysUser dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setCreateAccount(loginUser.getUserAccount());
		
		sysUserService.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(SysUser dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysUserService.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(SysUser dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysUserService.updateSelectiveByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("deleteByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto deleteByPK(Long id) {
		ResultDto resultDto=new ResultDto(1,"");
		sysUserService.deleteByPK(id);
		return resultDto;
	}
	
	@RequestMapping("selectByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public SysUser selectByPK(Long id) {
		return sysUserService.selectByPK(id);
	}
	
	@RequestMapping("selectByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public List<SysUser> selectByDto(SysUser dto) {
		return sysUserService.selectByDto(dto);
	}
	
	@RequestMapping("selectPageByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public PageResult<SysUser> selectPageByDto(SysUser dto,PageDto pageDto) {
		return sysUserService.selectPageByDto(dto,pageDto);
	}
}
