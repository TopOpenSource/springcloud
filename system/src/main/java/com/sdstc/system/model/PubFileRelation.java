package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PubFileRelation extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 关联类型
	 */
    private String type;
    /**
	 * 文件ID
	 */
    private Long fileId;
    /**
	 * 关联对象ID
	 */
    private Long refId;
    /**
	 * 
	 */
    private Long customerId;
}
