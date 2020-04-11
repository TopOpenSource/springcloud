package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysOrg extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 组织名称
	 */
    private String name;
    /**
	 * 组织路径
	 */
    private String path;
    /**
	 * 父级ID
	 */
    private Long pId;
    /**
	 * 客户ID
	 */
    private Long customerId;
}
