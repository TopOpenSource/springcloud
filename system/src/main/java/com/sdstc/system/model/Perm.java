package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author cheng
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Perm extends BaseModel{
	private Long id;
	private String code;
	private String name;
}
