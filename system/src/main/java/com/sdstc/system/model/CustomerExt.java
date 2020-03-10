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
public class CustomerExt  extends BaseModel{
   private Long id;
   private Long customerId;
   private char isServerInit;
   private char isLreInit;
}
