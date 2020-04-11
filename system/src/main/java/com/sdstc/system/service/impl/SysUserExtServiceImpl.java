package com.sdstc.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sdstc.pub.constant.PubConstant;
import com.sdstc.pub.constant.UserConstant;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import com.sdstc.pub.oauth.service.Snowflake;
import com.sdstc.system.dao.SysUserExtDao;
import com.sdstc.system.model.SysUserExt;
import com.sdstc.system.model.UserInfo;
import com.sdstc.system.service.SysUserExtService;

import lombok.extern.log4j.Log4j2;
/**
 * 
 * @author 
 *
 */
@Service("sysUserExtService")
@Log4j2
public class SysUserExtServiceImpl implements SysUserExtService{
    @Autowired
    private Snowflake snowflake;
    
    @Autowired
	private SysUserExtDao sysUserExtDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
	@Override
	public void insert(SysUserExt dto) {
		passwordEncoder.encode("xxx");
	    Date now=new Date();
	    dto.setId(snowflake.getId());
	    dto.setGmtCreate(now);
	    
		sysUserExtDao.insert(dto);
	}

	@Override
	public void updateByPK(SysUserExt dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysUserExtDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(SysUserExt dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysUserExtDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id) {
		sysUserExtDao.deleteByPK(id);
	}

	@Override
	public SysUserExt selectByPK(Long id) {
		return sysUserExtDao.selectByPK(id);
	}

	@Override
	public List<SysUserExt> selectByDto(SysUserExt dto) {
		return sysUserExtDao.selectByDto(dto);
	}

    @Override
	public PageResult<SysUserExt> selectPageByDto(SysUserExt dto, PageDto pageDto) {
	    pageDto.setCount(sysUserExtDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			List<SysUserExt> results=sysUserExtDao.selectPageByDto(dto, pageDto);
			return new PageResult<SysUserExt>(pageDto, results);
		}else {
			return new PageResult<SysUserExt>(pageDto, null);
		}
	}

	@Override
	public SysUserExt selectByUserDto(UserInfo dto) {
		return sysUserExtDao.selectByUserDto(dto);
	}

	@Override
	public void updateSelectiveByUserAccount(SysUserExt dto) {
		sysUserExtDao.updateSelectiveByUserAccount(dto);
	}

	@Override
	public void updateLoginFaildInfo(String userAccount) {
		UserInfo userInfo=new UserInfo(userAccount);
		SysUserExt userExt=this.selectByUserDto(userInfo);
		int failCount=userExt.getLoginFailCount()+1;
		userExt.setLoginFailCount(failCount);
		userExt.setLastLoginFailTime(new Date());
		sysUserExtDao.updateSelectiveByUserAccount(userExt);
	}

}
