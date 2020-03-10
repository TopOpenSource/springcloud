package com.sdstc.code.utils.freemarker;

import com.sdstc.code.model.Table;

/**
 * 生成 model
 * 
 * @author cheng
 *
 */
public class GeModel extends Generator {

	@Override
	protected void proccess(Table table) {
		try {
			super.genarator(table, table.getModelPath(), "ftl/Model.ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
