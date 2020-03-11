package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PubDict extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 字典名称
	 */
    private String name;
    /**
	 * 字典code
	 */
    private String code;
    /**
	 * 父级ID
	 */
    private Long pId;
    /**
	 * 路径
	 */
    private String path;
}
