package com.sdstc.system.service.impl;

import com.sdstc.pub.oauth.service.Snowflake;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdstc.system.dao.SysCustomerDao;
import com.sdstc.system.model.SysCustomer;
import com.sdstc.system.service.SysCustomerService;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
/**
 * 
 * @author 
 *
 */
@Service("sysCustomerService")
@Log4j2
public class SysCustomerServiceImpl implements SysCustomerService{
    @Autowired
    private Snowflake snowflake;
    
    @Autowired
	private SysCustomerDao sysCustomerDao;
    
	@Override
	public void insert(SysCustomer dto) {
	    Date now=new Date();
	    dto.setId(snowflake.getId());
	    dto.setGmtCreate(now);
	    
		sysCustomerDao.insert(dto);
	}

	@Override
	public void updateByPK(SysCustomer dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysCustomerDao.updateByPK(dto);
	}

	@Override
	public void updateSelectiveByPK(SysCustomer dto) {
	    Date now=new Date();
		dto.setGmtModified(now);
		
		sysCustomerDao.updateSelectiveByPK(dto);
	}

	@Override
	public void deleteByPK(Long id) {
		sysCustomerDao.deleteByPK(id);
	}

	@Override
	public SysCustomer selectByPK(Long id) {
		return sysCustomerDao.selectByPK(id);
	}

	@Override
	public List<SysCustomer> selectByDto(SysCustomer dto) {
		return sysCustomerDao.selectByDto(dto);
	}

    @Override
	public PageResult<SysCustomer> selectPageByDto(SysCustomer dto, PageDto pageDto) {
	    pageDto.setCount(sysCustomerDao.selectCountByDto(dto));
		if(pageDto.getCount()> 0) {
			List<SysCustomer> results=sysCustomerDao.selectPageByDto(dto, pageDto);
			return new PageResult<SysCustomer>(pageDto, results);
		}else {
			return new PageResult<SysCustomer>(pageDto, null);
		}
	}
}
