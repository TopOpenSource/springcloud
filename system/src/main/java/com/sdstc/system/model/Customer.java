package com.sdstc.system.model;

import java.util.Date;

import com.sdstc.pub.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author cheng
 *
 * @Data
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Customer extends BaseModel {
	private Long id;
	private String name;
	private String no;
	private String phone;
	private String email;
	private Long cardImageId;
	private String address;
	private Date registerDate;
	private char state;
	private char payState;
	private Date expiryDate;

}
