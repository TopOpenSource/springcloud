package com.sdstc.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.system.model.PubDict;
import com.sdstc.system.service.PubDictService;

@RestController
@RequestMapping("/api/system/pubDict")
public class PubDictController {
	@Autowired
	private PubDictService pubDictService;
	
	@RequestMapping("insert")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(PubDict dto) {
		ResultDto resultDto=new ResultDto(1,"");
		pubDictService.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(PubDict dto) {
		ResultDto resultDto=new ResultDto(1,"");
		pubDictService.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(PubDict dto) {
		ResultDto resultDto=new ResultDto(1,"");
		pubDictService.updateSelectiveByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("deleteByPK")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto deleteByPK(Long id) {
		ResultDto resultDto=new ResultDto(1,"");
		pubDictService.deleteByPK(id);
		return resultDto;
	}
	
	@RequestMapping("selectByPK")
	@PreAuthorize("hasRole('ROLE_USER')")
	public PubDict selectByPK(Long id) {
		return pubDictService.selectByPK(id);
	}
	
	@RequestMapping("selectByDto")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<PubDict> selectByDto(PubDict dto) {
		return pubDictService.selectByDto(dto);
	}
	
	@RequestMapping("selectPageByDto")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<PubDict> selectPageByDto(PubDict dto,PageDto pageDto) {
		return pubDictService.selectPageByDto(dto,pageDto);
	}
}
