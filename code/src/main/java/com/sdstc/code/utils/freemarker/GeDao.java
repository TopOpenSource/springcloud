package com.sdstc.code.utils.freemarker;

import com.sdstc.code.model.Table;
import com.sdstc.code.utils.Params;

/**
 * 生成dao
 * 
 * @author cheng
 *
 */
public class GeDao extends Generator {
    
	public void proccess(Table table,String basePath) {
		
		try {
			super.genarator(table,basePath+table.getDaoPath(),table.getEntityName()+"Dao.java", "ftl/Dao.ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
