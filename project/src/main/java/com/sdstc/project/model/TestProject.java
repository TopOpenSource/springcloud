package com.sdstc.project.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class TestProject extends BaseModel {
    /**
	 * 
	 */
    private Long id;
    /**
	 * 客户ID
	 */
    private Long customerId;
    /**
	 * 项目名称
	 */
    private String name;
    /**
	 * 项目状态 1 正常 2停用 3删除
	 */
    private char state;
    /**
	 * 项目开始日期
	 */
    private Date startDate;
    /**
	 * 项目结束日期
	 */
    private Date endDate;
    /**
	 * 项目类型 0 LRE
	 */
    private String type;
}
