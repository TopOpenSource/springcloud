package com.sdstc.delivery.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.config.RabbitConfig;
import com.sdstc.delivery.dto.AliyunDto;
import com.sdstc.delivery.service.DeliveryFanoutService;

import lombok.extern.log4j.Log4j2;

/**
 * 交付消息队列发送处理实现类
 * @author sunk
 *
 */
@Service("deliveryFanoutService")
@Log4j2
public class DeliveryFanoutServiceImpl implements DeliveryFanoutService {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Override
	public void sendToDeliveryECS(AliyunDto aliyunDto) {
		
		rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE_DELIVERYECS, "", aliyunDto);
		
	}

}
