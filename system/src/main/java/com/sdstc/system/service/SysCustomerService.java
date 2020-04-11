package com.sdstc.system.service;

import java.util.List;
import com.sdstc.system.model.SysCustomer;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.dto.PageResult;
/**
 * 
 * @author
 *
 */
public interface SysCustomerService {
	void insert(SysCustomer dto);

	void updateByPK(SysCustomer dto);

	void updateSelectiveByPK(SysCustomer dto);

	void deleteByPK(Long id);

	SysCustomer selectByPK(Long id);

	List<SysCustomer> selectByDto(SysCustomer dto);
	
	PageResult<SysCustomer> selectPageByDto(SysCustomer dto,PageDto pageDto);
}
