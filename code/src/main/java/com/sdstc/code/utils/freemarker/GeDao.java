package com.sdstc.code.utils.freemarker;

import com.sdstc.code.model.Table;

/**
 * 生成dao
 * 
 * @author cheng
 *
 */
public class GeDao extends Generator {
    
	@Override
	protected void proccess(Table table) {
		try {
			super.genarator(table, table.getDaoPath(), "ftl/Dao.ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		GeDao geDao=new GeDao();
		geDao.proccess(new Table());
	}
}
