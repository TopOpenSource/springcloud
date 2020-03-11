package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PubMessage extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 客户ID
	 */
    private Long customerId;
    /**
	 * 消息类型
	 */
    private String type;
    /**
	 * 消息级别
	 */
    private Integer level;
    /**
	 * 消息内容
	 */
    private String info;
    /**
	 * 消息状态(0 未读 1 已读)
	 */
    private char status;
    /**
	 * 消息接收人
	 */
    private String owner;
}
