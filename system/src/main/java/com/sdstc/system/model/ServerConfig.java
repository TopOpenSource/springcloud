package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ServerConfig extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 配置类型 0 k8s 1 短信服务 2 LR 3 消息队列 4 redis 5 阿里云
	 */
    private char type;
    /**
	 * 属性名
	 */
    private String key;
    /**
	 * 属性值
	 */
    private String value;
}
