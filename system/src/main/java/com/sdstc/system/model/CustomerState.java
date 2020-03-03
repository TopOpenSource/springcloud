package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CustomerState  extends BaseModel{
   private Long id;
   private Long customerId;
   private char isServerInit;
   private char isLreInit;
}
