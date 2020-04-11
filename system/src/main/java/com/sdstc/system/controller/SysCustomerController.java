package com.sdstc.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.system.model.SysCustomer;
import com.sdstc.pub.oauth.service.Oauth2Service;
import com.sdstc.system.service.SysCustomerService;
import com.sdstc.pub.dto.LoginUserInfo;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/system/sysCustomer")
@Log4j2
public class SysCustomerController {
	@Autowired
	private SysCustomerService sysCustomerService;
	@Autowired
	private  Oauth2Service oauth2Service;
	
	@RequestMapping("insert")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(SysCustomer dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setCreateAccount(loginUser.getUserAccount());
		
		sysCustomerService.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(SysCustomer dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysCustomerService.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(SysCustomer dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysCustomerService.updateSelectiveByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("deleteByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto deleteByPK(Long id) {
		ResultDto resultDto=new ResultDto(1,"");
		sysCustomerService.deleteByPK(id);
		return resultDto;
	}
	
	@RequestMapping("selectByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public SysCustomer selectByPK(Long id) {
		return sysCustomerService.selectByPK(id);
	}
	
	@RequestMapping("selectByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public List<SysCustomer> selectByDto(SysCustomer dto) {
		return sysCustomerService.selectByDto(dto);
	}
	
	@RequestMapping("selectPageByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public PageResult<SysCustomer> selectPageByDto(SysCustomer dto,PageDto pageDto) {
		return sysCustomerService.selectPageByDto(dto,pageDto);
	}
}
