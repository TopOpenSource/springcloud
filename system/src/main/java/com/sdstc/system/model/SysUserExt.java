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
public class SysUserExt extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 上次登录时间
	 */
    private Date lastLoginTime;
    /**
	 * 上次登录失败时间
	 */
    private Date lastLoginFailTime;
    /**
	 * 上次登录地址
	 */
    private String lastLoginAddr;
    /**
	 * 登录失败次数
	 */
    private Integer loginFailCount;
    /**
	 * LRE对应账号
	 */
    private String lreAccount;
    /**
	 * LRE对应密码
	 */
    private String lrePwd;
}
