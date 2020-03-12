package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PubFile extends BaseModel {
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
}
