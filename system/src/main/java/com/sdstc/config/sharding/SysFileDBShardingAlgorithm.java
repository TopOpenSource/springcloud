package com.sdstc.config.sharding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

/**
 * SysFile自定义分片
 * @author cheng
 *
 */
public class SysFileDBShardingAlgorithm implements ComplexKeysShardingAlgorithm{

	/**
	 * availableTargetNames:所有的数据源
	 * shardingValue  相关的值
	 */
	@Override
	public Collection doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
		Map<String,Object> shardingCols=shardingValue.getColumnNameAndShardingValuesMap();
		//获取租户ID
		List<Long> customerIds= (List<Long>) shardingCols.get("customer_id");
		Long customerId=customerIds.get(0);
		//获取模块
		List<String> modules= (List<String>) shardingCols.get("module");
		String module=modules.get(0);
        //返回数据库		
 		List<String> shardingResults = new ArrayList<>();
		if(module.equals("0")) {
			//返回system库
			shardingResults.add("system");
		}else if(module.equals("1")) {
			//返回Product-N库
			long rem=customerId%3;
			shardingResults.add("lre-project-"+rem);
		}
		return shardingResults;
	}

}
