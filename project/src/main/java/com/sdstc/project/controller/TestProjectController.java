package com.sdstc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.ResultDto;
import com.sdstc.project.model.TestProject;
import com.sdstc.oauth.service.Oauth2Service;
import com.sdstc.project.service.TestProjectService;

@RestController
@RequestMapping("/api/project/testProject")
public class TestProjectController {
	@Autowired
	private TestProjectService testProjectService;
	@Autowired
	private  Oauth2Service oauth2Service;
	
	@RequestMapping("insert")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto insert(TestProject dto) {
		ResultDto resultDto=new ResultDto(1,"");
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		testProjectService.insert(dto);
		return resultDto;
	}
	
	@RequestMapping("updateByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateByPK(TestProject dto) {
		ResultDto resultDto=new ResultDto(1,"");
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		testProjectService.updateByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("updateSelectiveByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto updateSelectiveByPK(TestProject dto) {
		ResultDto resultDto=new ResultDto(1,"");
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		testProjectService.updateSelectiveByPK(dto);
		return resultDto;
	}
	
	@RequestMapping("deleteByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResultDto deleteByPK(Long id) {
		ResultDto resultDto=new ResultDto(1,"");
		testProjectService.deleteByPK(id,oauth2Service.userInfo().getCustomerId());
		return resultDto;
	}
	
	@RequestMapping("selectByPK")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public TestProject selectByPK(Long id) {
		return testProjectService.selectByPK(id,oauth2Service.userInfo().getCustomerId());
	}
	
	@RequestMapping("selectByDto")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public List<TestProject> selectByDto(TestProject dto) {
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		return testProjectService.selectByDto(dto);
	}
	
	@RequestMapping("selectPageByDto")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<TestProject> selectPageByDto(TestProject dto,PageDto pageDto) {
		dto.setCustomerId(oauth2Service.userInfo().getCustomerId());
		return testProjectService.selectPageByDto(dto,pageDto);
	}
}
