package com.sdstc.code.model;

import lombok.Data;

@Data
public class Column {
   private String columnName;
   private String dataType;
   private String columnKey;
   //备注
   private String columnComment;
   
}
