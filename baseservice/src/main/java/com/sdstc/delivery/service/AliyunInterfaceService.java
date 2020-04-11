package com.sdstc.delivery.service;

import java.io.IOException;

import org.springframework.amqp.core.Message;

import com.rabbitmq.client.Channel;
import com.sdstc.delivery.dto.AliyunDto;

/**
 * 阿里云调用处理接口类
 * @author sunk
 *
 */
public interface AliyunInterfaceService {
	
	/**
	 * 交付ECS消息接收处理
	 * @param aliyunDto 参数信息对象
	 */
	void deliveryECS(AliyunDto aliyunDto, Channel channel, Message message)  throws IOException;
	
}
