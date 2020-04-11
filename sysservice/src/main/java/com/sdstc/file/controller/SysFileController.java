package com.sdstc.file.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.file.dto.PolicyDto;
import com.sdstc.file.model.SysFile;
import com.sdstc.pub.oauth.service.Oauth2Service;
import com.sdstc.file.service.FileService;
import com.sdstc.file.service.SysFileService;
import com.sdstc.pub.dto.LoginUserInfo;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/file/sysFile")
@Log4j2
public class SysFileController {
	@Autowired
	private SysFileService sysFileService;
	@Autowired
	private  Oauth2Service oauth2Service;
	
	@Autowired
	private FileService ossService;

	@RequestMapping("getToken")
	public PolicyDto getPolicy() throws UnsupportedEncodingException {
		return ossService.getPolicy("test-chengang","test");
	}
	
	@RequestMapping("insert")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(SysFile dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setCustomerId(loginUser.getCustomerId());
		dto.setCreateAccount(loginUser.getUserAccount());
		
		sysFileService.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(SysFile dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setCustomerId(loginUser.getCustomerId());
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysFileService.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(SysFile dto) {
		ResultDto resultDto=new ResultDto(1,"");
		LoginUserInfo loginUser=oauth2Service.userInfo();
		dto.setCustomerId(loginUser.getCustomerId());
		dto.setModifiedAccount(loginUser.getUserAccount());
		
		sysFileService.updateSelectiveByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("deleteByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto deleteByPK(Long id) {
		ResultDto resultDto=new ResultDto(1,"");
		sysFileService.deleteByPK(id,oauth2Service.userInfo().getCustomerId());
		return resultDto;
	}
	
	@RequestMapping("selectByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public SysFile selectByPK(Long id) {
		return sysFileService.selectByPK(id,oauth2Service.userInfo().getCustomerId());
	}
	
	@RequestMapping("selectByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public List<SysFile> selectByDto(SysFile dto) {
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		return sysFileService.selectByDto(dto);
	}
	
	@RequestMapping("selectPageByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public PageResult<SysFile> selectPageByDto(SysFile dto,PageDto pageDto) {
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		return sysFileService.selectPageByDto(dto,pageDto);
	}
}
