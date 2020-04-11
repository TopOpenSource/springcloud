package com.sdstc.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.delivery.dto.AliyunDto;
import com.sdstc.delivery.service.DeliveryFanoutService;

import lombok.extern.log4j.Log4j2;

/**
 * 交付消息队列发送处理
 * @author sunk
 *
 */
@RestController
@RequestMapping("/api/baseservice/delivery/deliveryfanout")
@Log4j2
public class DeliveryFanoutController {
	
	@Autowired
	private DeliveryFanoutService deliveryFanoutService;
	
	@RequestMapping("deliveryECS")
	public void deliveryECS(AliyunDto aliyunDto) {
		
		deliveryFanoutService.sendToDeliveryECS(aliyunDto);
		
	}

}
