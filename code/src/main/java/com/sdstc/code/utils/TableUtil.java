package com.sdstc.code.utils;

import java.util.List;

import com.sdstc.code.model.Column;
import com.sdstc.code.model.Table;

public class TableUtil {
	public static void main(String[] args) {

	}

	public static Table parseTable(String tableName, List<Column> sqlCols, String daoPackage, String modelPackage, String xmlPackage) {
		Table table = new Table();
		table.setTableName(tableName);
		table.setEntityName(Params.firestUpperCase(Params.underlineToCamel(tableName)));

		table.setXmlPath(xmlPackage);
		table.setModelPath(Params.parsePackage2Path(modelPackage));
		table.setModelPackage(modelPackage);
		table.setDaoPath(Params.parsePackage2Path(daoPackage));
		table.setDaoPackage(daoPackage);
		
		
		Boolean hasDate = false;
		Boolean hasBigDecimal=false;

		Boolean hasTenant = false;
		String tenantKey = null;
		String sqlTenantKey = null;
		String primaryKey = null;
		String sqlPk = null;

		for (Column sqlCol : sqlCols) {
			Column col = parseCol(sqlCol);
			if ("Date".equals(col.getJavaDataType())) {
				hasDate = true;
			} else if("BigDecimal".equals(col.getJavaDataType())){
				hasBigDecimal=true;
			}else {
				
			}

			if (Params.tenantCol.equals(col.getColumnName())) {
				hasTenant = true;
				tenantKey=col.getJavaColumnName();
				sqlTenantKey=col.getColumnName();
			}

			if (col.getIsPK()!=null && col.getIsPK()) {
				primaryKey = col.getJavaColumnName();
				sqlPk=col.getColumnName();
			}

			table.addCol(col);
		}

		
		table.setHasDate(hasDate);
		table.setHasBigDecimal(hasBigDecimal);
		
		table.setHasTenant(hasTenant);
		table.setTenantKey(tenantKey);
		table.setSqlTenantKey(sqlTenantKey);
		
		table.setPrimaryKey(primaryKey);
		table.setSqlPk(sqlPk);
		
		return table;
	}

	public static Column parseCol(Column col) {
		col.setJavaColumnName(Params.underlineToCamel(col.getColumnName()));
		col.setJavaDataType(Params.colTypes.get(col.getDataType()));
		if (col.getColumnKey() != null && "PRI".equals(col.getColumnKey())) {
			col.setIsPK(true);
		}else {
			col.setIsPK(false);
		}
		if(Params.parentColumns.contains(col.getColumnName())) {
			col.setIsParentCol(true);
		}else {
			col.setIsParentCol(false);
		}
		return col;
	}
}
