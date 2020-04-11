package com.sdstc.system.model;

import java.util.Date;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserRole extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 用户account
	 */
    private String userAccount;
    /**
	 * 角色ID
	 */
    private Long roleId;
    /**
	 * 单位ID
	 */
    private Long customerId;
    
    public UserRole(Long id, String createAccount, Date gmtCreate, String userAccount, Long roleId, Long customerId) {
    	this.id = id;
    	this.setCreateAccount(createAccount);
    	this.setGmtCreate(gmtCreate);
    	this.userAccount = userAccount;
    	this.roleId = roleId;
    	this.customerId = customerId;
    }
}
