package com.sdstc.file.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysFile extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 文件名
	 */
    private String name;
    /**
	 * 文件大小
	 */
    private BigDecimal size;
    /**
	 * 文件所在路径
	 */
    private String path;
    /**
	 * 文件类型
	 */
    private String type;
    /**
	 * 客户ID
	 */
    private Long customerId;
    /**
	 * 模块 0 system 1product 2order
	 */
    private String module;
    /**
	 * 存储类型 0 oss 1本地
	 */
    private String storeType;
}
