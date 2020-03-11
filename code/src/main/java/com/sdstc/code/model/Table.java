package com.sdstc.code.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Table {
	// 是否包含 date
	private Boolean hasDate;
	//是否包含BigDecimal
	private Boolean hasBigDecimal;
	
	
	// 主键
	private String primaryKey;
	private String sqlPk;
	// 租户键
	// 是否包含租户字段
	private Boolean hasTenant;
	private String tenantKey;
	private String sqlTenantKey;

	// 实体名
	private String entityName;
	// 表名
	private String tableName;
	
	// dao路径
	private String daoPackage;
	private String daoPath;
	// model路径
	private String modelPackage;
	private String modelPath;
	//service接口路径
	private String serviceInterPackage;
	private String serviceInterPath;
	//service实现路径
	private String servicePackage;
	private String servicePath;
	
	// xml路径
	private String xmlPath;

	private List<Column> cols;

	public void addCol(Column col) {
       if(this.cols==null) {
    	   this.cols=new ArrayList<Column>();
       }
       this.cols.add(col);
	}
}
