package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysRole extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 角色名
	 */
    private String name;
    /**
	 * 角色编码
	 */
    private String code;
}
