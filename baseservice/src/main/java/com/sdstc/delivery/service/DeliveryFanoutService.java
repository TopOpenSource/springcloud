package com.sdstc.delivery.service;

import com.sdstc.delivery.dto.AliyunDto;

/**
 * 交付消息队列发送处理接口类
 * @author sunk
 *
 */
public interface DeliveryFanoutService {
	
	/**
	 * 交付ECS消息发送处理
	 * @param aliyunDto 参数信息对象
	 */
	void sendToDeliveryECS(AliyunDto aliyunDto);

}
