package com.sdstc.code.utils.freemarker;

import com.sdstc.code.model.Table;
import com.sdstc.code.utils.Params;

/**
 * 生成mapperxml文件
 * @author cheng
 *
 */
public class GeMapperXml extends Generator{

	public void proccess(Table table,String basePath) {
		try {
			super.genarator(table, basePath+table.getXmlPath(),table.getEntityName()+"Dao.xml","ftl/Mapper.ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
}
