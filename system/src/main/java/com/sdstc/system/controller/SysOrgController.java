package com.sdstc.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.system.model.SysOrg;
import com.sdstc.pub.oauth.service.Oauth2Service;
import com.sdstc.system.service.SysOrgService;
import com.sdstc.pub.dto.LoginUserInfo;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/system/sysOrg")
@Log4j2
public class SysOrgController {
	@Autowired
	private SysOrgService sysOrgService;
	@Autowired
	private  Oauth2Service oauth2Service;
	
	@RequestMapping("insert")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(SysOrg dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setCustomerId(loginUser.getCustomerId());
		dto.setCreateAccount(loginUser.getUserAccount());
		
		sysOrgService.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(SysOrg dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setCustomerId(loginUser.getCustomerId());
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysOrgService.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(SysOrg dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setCustomerId(loginUser.getCustomerId());
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysOrgService.updateSelectiveByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("deleteByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto deleteByPK(Long id) {
		ResultDto resultDto=new ResultDto(1,"");
		sysOrgService.deleteByPK(id,oauth2Service.userInfo().getCustomerId());
		return resultDto;
	}
	
	@RequestMapping("selectByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public SysOrg selectByPK(Long id) {
		return sysOrgService.selectByPK(id,oauth2Service.userInfo().getCustomerId());
	}
	
	@RequestMapping("selectByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public List<SysOrg> selectByDto(SysOrg dto) {
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		return sysOrgService.selectByDto(dto);
	}
	
	@RequestMapping("selectPageByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public PageResult<SysOrg> selectPageByDto(SysOrg dto,PageDto pageDto) {
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		return sysOrgService.selectPageByDto(dto,pageDto);
	}
}
