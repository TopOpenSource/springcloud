package com.sdstc.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.system.model.SysUserExt;
import com.sdstc.system.service.SysUserExtService;

@RestController
@RequestMapping("/api/system/sysUserExt")
public class SysUserExtController {
	@Autowired
	private SysUserExtService sysUserExtService;
	
	@RequestMapping("insert")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(SysUserExt dto) {
		ResultDto resultDto=new ResultDto(1,"");
		sysUserExtService.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(SysUserExt dto) {
		ResultDto resultDto=new ResultDto(1,"");
		sysUserExtService.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(SysUserExt dto) {
		ResultDto resultDto=new ResultDto(1,"");
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
	public List<SysUserExt> selectPageByDto(SysUserExt dto,PageDto pageDto) {
		return sysUserExtService.selectPageByDto(dto,pageDto);
	}
}
