package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PubLog extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 客户ID
	 */
    private Long customerId;
    /**
	 * 日志类型
	 */
    private String type;
    /**
	 * 日志级别
	 */
    private Integer level;
    /**
	 * 日志内容
	 */
    private String info;
    /**
	 * 日志状态(0 未处理 1 已处理 2无法处理)
	 */
    private char status;
}
