package com.sdstc.delivery.dto;

import java.io.Serializable;
import java.util.List;

import com.aliyuncs.ecs.model.v20140526.RunInstancesRequest.DataDisk;

import lombok.Data;

/**
 * 参数信息封装处理类
 * @author sunk
 *
 */
@Data
public class AliyunDto implements Serializable {
	
	private static final long serialVersionUID = -2984840744911959417L;
	
	/**
	 * ECS参数
	 */
	private String serverId;// server表业务主键
	private String regionId;// 区域id
	private String instanceId;// 实例id
	private String imageId;// 镜像id
	private String instanceType;// 实例的资源规格
	private String securityGroupId;// 安全组id
	private String vSwitchId;// 虚拟交换机id。如果创建VPC类型ECS实例，必须指定虚拟交换机id，且安全组和虚拟交换机在同一个专有网络VPC中
	private String instanceName;// 实例名称
	private String description;// 描述
	private int internetMaxBandwidthOut;// 公网出带宽最大值，单位Mbit/s
	private String hostName;// 实例主机名称
	private String pwd;// 实例的密码
	private String internetChargeType;// 网络计费类型
	private int amount = 5;// 创建ECS实例数量，数值范围为1~100
	private int period;// 购买时长，单位由参数periodUnit决定，取值范围如下：PeriodUnit=Week时，Period取值：{“1”, “2”, “3”, “4”}；PeriodUnit=Month时，Period取值：{“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”, “9”, “12”, “24”, “36”, ”48”, ”60”}
	private String periodUnit;// 包年包月计费方式的时长单位。Week或Month
	private String instanceChargeType;// 实例付费方式。PrePaid：包年包月；PostPaid：按量付费，且账户余额大于100元
	private String systemDiskSize;// 系统盘大小，单位GiB
	private String systemDiskCategory;// 系统盘类型
	private String systemDiskName;// 系统盘名称
	private String systemDiskDescription;// 系统盘描述
	private List<DataDisk> dataDisk;// 数据盘信息集合

}
