package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysUserOrg extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 客户ID（冗余）
	 */
    private Long customerId;
    /**
	 * 所属组织ID
	 */
    private Long orgId;
    /**
	 * 用户ID
	 */
    private String userAccount;
    /**
	 * 用户状态 0 禁用 1启用
	 */
    private String state;
}
