package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysCustomer extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 单位名称
	 */
    private String name;
    /**
	 * 组织机构代码
	 */
    private String no;
    /**
	 * 联系人手机号码
	 */
    private String phone;
    /**
	 * 联系人邮箱
	 */
    private String email;
    /**
	 * 营业执照文件ID
	 */
    private Long cardImageId;
    /**
	 * 单位所在地址
	 */
    private String address;
    /**
	 * 注册日期
	 */
    private Date registerDate;
    /**
	 * 认证状态 0 未认证 1已认证
	 */
    private String state;
}
