package com.sdstc.delivery.service.impl;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.RunInstancesRequest;
import com.aliyuncs.ecs.model.v20140526.RunInstancesResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.sdstc.config.RabbitConfig;
import com.sdstc.delivery.dto.AliyunDto;
import com.sdstc.delivery.service.AliyunInterfaceService;
import com.sdstc.pub.constant.SysConfigConstant;
import com.sdstc.sysconfig.service.SysConfigService;

import lombok.extern.log4j.Log4j2;

/**
 * 阿里云调用处理实现类
 * @author sunk
 *
 */
@Service("aliyunInterfaceService")
@Log4j2
public class AliyunInterfaceServiceImpl implements AliyunInterfaceService {
	
	private static final boolean DRY_RUN = true;// 是否只预检此次请求。true：发送检查请求，不会创建实例。如果检查不通过，则返回对应错误，如果检查通过，则返回错误代码DryRunOperation；false：发送正常请求，检查通过后立即创建实例。默认false
	
	@Autowired
	private SysConfigService sysConfigService;
	
	@Override
	@RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_DELIVERYECS1)
	public void deliveryECS(AliyunDto aliyunDto, Channel channel, Message message) throws IOException {
		
		DefaultProfile profile = DefaultProfile.getProfile(aliyunDto.getRegionId(), sysConfigService.getConfigAsStr(SysConfigConstant.ALIYUN, "ACCESS_KEY_ID"), sysConfigService.getConfigAsStr(SysConfigConstant.ALIYUN, "ACCESS_KEY_SECRET"));
        IAcsClient client = new DefaultAcsClient(profile);
        
        RunInstancesRequest request = new RunInstancesRequest();
        request.setSysRegionId(aliyunDto.getRegionId());// 区域id
        request.setInstanceType(aliyunDto.getInstanceType());// 实例的资源规格
        request.setImageId(aliyunDto.getImageId());// 镜像id
        request.setHostName(aliyunDto.getHostName());// 主机名
        request.setSecurityGroupId(aliyunDto.getSecurityGroupId());// 安全组id
        request.setVSwitchId(aliyunDto.getVSwitchId());// 虚拟交换机id
        request.setInstanceName(aliyunDto.getInstanceName());// 实例名称
        request.setDescription(aliyunDto.getDescription());// 描述
        request.setInternetMaxBandwidthOut(aliyunDto.getInternetMaxBandwidthOut());// 公网出带宽最大值，单位Mbit/s
        request.setPassword(aliyunDto.getPwd());// 实例的密码
        request.setInternetChargeType(aliyunDto.getInternetChargeType());// 网络计费类型
        request.setAmount(aliyunDto.getAmount());// 创建ECS实例数量，数值范围为1~100
        request.setInstanceChargeType(aliyunDto.getInstanceChargeType());// 实例付费方式
        request.setPeriod(aliyunDto.getPeriod());// 购买时长
        request.setPeriodUnit(aliyunDto.getPeriodUnit());// 包年包月计费方式的时长单位
        
        if (null != aliyunDto.getSystemDiskSize()) {
        	request.setSystemDiskSize(aliyunDto.getSystemDiskSize());// 系统盘大小
        }
        
        if (null != aliyunDto.getSystemDiskCategory()) {
        	request.setSystemDiskCategory(aliyunDto.getSystemDiskCategory());// 系统盘类型
        }
        
        if (null != aliyunDto.getSystemDiskName()) {
        	request.setSystemDiskDiskName(aliyunDto.getSystemDiskName());// 系统盘名称
        }
        
        if (null != aliyunDto.getSystemDiskDescription()) {
        	request.setSystemDiskDescription(aliyunDto.getSystemDiskDescription());// 系统盘描述
        }
        
        if (null != aliyunDto.getDataDisk()) {
        	request.setDataDisks(aliyunDto.getDataDisk());// 数据盘信息集合
        }
        
        request.setDryRun(DRY_RUN);// 是否只预检此次请求
        
		try {
			
			RunInstancesResponse response = client.getAcsResponse(request);
			System.out.println(new Gson().toJson(response));
			
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
		}
		
	}

}
