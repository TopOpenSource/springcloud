package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysDict extends BaseModel {
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
	 * 父级code
	 */
    private String pCode;
    /**
	 * 路径  "code1/code2/code3" 可用于验证重复
	 */
    private String path;
    /**
	 * 排序序号,同级排序
	 */
    private Integer orderNo;
    
    /**
     * 父级路径 -不存储
     */
    private String pPath;
}
