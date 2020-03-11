package com.sdstc.code;

import com.sdstc.code.model.Table;
import com.sdstc.code.utils.Mybatis;
import com.sdstc.code.utils.TableUtil;
import com.sdstc.code.utils.freemarker.GeDao;
import com.sdstc.code.utils.freemarker.GeMapperXml;
import com.sdstc.code.utils.freemarker.GeModel;
import com.sdstc.code.utils.freemarker.GeService;
import com.sdstc.code.utils.freemarker.GeServiceImpl;

public class CodeStart {
	public static void main(String[] args) {
		// 模块名 为空放到c盘
		String basePath = "D://";
		// dao包名
		String daoPackage = "com.sdstc.system.dao";
		// model包名
		String modelPackage = "com.sdstc.system.model";
		//service接口包名
		String serviceInterPackage="com.sdstc.system.service";
		//service包名
		String servicePackage="com.sdstc.system.service.impl";
		
		// xml路径
		String xmlPackage = "resources/mapper/system";

		// 数据源 不可为空
		String jdbcUrl = "172.16.200.12:30686";
		String scheme = "system";
		String userName = "root";
		String pwd = "qwe123-=";
		String tableName = "pub_file";

		Mybatis mybatis = new Mybatis(jdbcUrl, scheme, userName, pwd, tableName);
		Table table = TableUtil.parseTable(tableName, mybatis.getColumns(), daoPackage, modelPackage, xmlPackage,serviceInterPackage,servicePackage);

		GeDao geDao = new GeDao();
		geDao.proccess(table,basePath);
		GeMapperXml geMapper = new GeMapperXml();
		geMapper.proccess(table,basePath);
		GeModel geModel = new GeModel();
        geModel.proccess(table,basePath);
        GeService geService=new GeService();
        geService.proccess(table, basePath);
        GeServiceImpl geServiceImpl=new GeServiceImpl();
        geServiceImpl.proccess(table, basePath);
        
	}

}
