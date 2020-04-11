package com.sdstc.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.system.model.SysUserExt;
import com.sdstc.pub.oauth.service.Oauth2Service;
import com.sdstc.system.service.SysUserExtService;
import com.sdstc.pub.dto.LoginUserInfo;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/system/sysUserExt")
@Log4j2
public class SysUserExtController {
	@Autowired
	private SysUserExtService sysUserExtService;
	@Autowired
	private  Oauth2Service oauth2Service;
	
	@RequestMapping("insert")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(SysUserExt dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setCreateAccount(loginUser.getUserAccount());
		
		sysUserExtService.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(SysUserExt dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysUserExtService.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(SysUserExt dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysUserExtService.updateSelectiveByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("deleteByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto deleteByPK(Long id) {
		ResultDto resultDto=new ResultDto(1,"");
		sysUserExtService.deleteByPK(id);
		return resultDto;
	}
	
	@RequestMapping("selectByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public SysUserExt selectByPK(Long id) {
		return sysUserExtService.selectByPK(id);
	}
	
	@RequestMapping("selectByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public List<SysUserExt> selectByDto(SysUserExt dto) {
		return sysUserExtService.selectByDto(dto);
	}
	
	@RequestMapping("selectPageByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public PageResult<SysUserExt> selectPageByDto(SysUserExt dto,PageDto pageDto) {
		return sysUserExtService.selectPageByDto(dto,pageDto);
	}
}
