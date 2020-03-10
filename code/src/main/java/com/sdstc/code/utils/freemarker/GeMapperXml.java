package com.sdstc.code.utils.freemarker;

import com.sdstc.code.model.Table;

/**
 * 生成mapperxml文件
 * @author cheng
 *
 */
public class GeMapperXml extends Generator{

	@Override
	protected void proccess(Table table) {
		try {
			super.genarator(table, table.getXmlPath(), "ftl/Mapper.ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
}
