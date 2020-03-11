package com.sdstc.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.system.model.PubMessage;
import com.sdstc.oauth.service.Oauth2Service;
import com.sdstc.system.service.PubMessageService;

@RestController
@RequestMapping("/api/system/pubMessage")
public class PubMessageController {
	@Autowired
	private PubMessageService pubMessageService;
	@Autowired
	private  Oauth2Service oauth2Service;
	
	@RequestMapping("insert")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(PubMessage dto) {
		ResultDto resultDto=new ResultDto(1,"");
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		pubMessageService.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(PubMessage dto) {
		ResultDto resultDto=new ResultDto(1,"");
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		pubMessageService.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(PubMessage dto) {
		ResultDto resultDto=new ResultDto(1,"");
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		pubMessageService.updateSelectiveByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("deleteByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto deleteByPK(Long id) {
		ResultDto resultDto=new ResultDto(1,"");
		pubMessageService.deleteByPK(id,oauth2Service.userInfo().getCustomerId());
		return resultDto;
	}
	
	@RequestMapping("selectByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public PubMessage selectByPK(Long id) {
		return pubMessageService.selectByPK(id,oauth2Service.userInfo().getCustomerId());
	}
	
	@RequestMapping("selectByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public List<PubMessage> selectByDto(PubMessage dto) {
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		return pubMessageService.selectByDto(dto);
	}
	
	@RequestMapping("selectPageByDto")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<PubMessage> selectPageByDto(PubMessage dto,PageDto pageDto) {
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		return pubMessageService.selectPageByDto(dto,pageDto);
	}
}
