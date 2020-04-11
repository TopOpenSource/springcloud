package com.sdstc.config.sharding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

/**
 * SysFileRel自定义分片
 * 
 * @author cheng
 *
 */
public class SysFileRelTBShardingAlgorithm implements ComplexKeysShardingAlgorithm {

	@Override
	public Collection doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
		Map<String, Object> shardingCols = shardingValue.getColumnNameAndShardingValuesMap();
		// 获取租户ID
		List<Long> customerIds = (List<Long>) shardingCols.get("customer_id");
		Long customerId = customerIds.get(0);
		// 获取模块
		List<String> modules = (List<String>) shardingCols.get("module");
		String module = modules.get(0);
		// 返回数据库
		List<String> shardingResults = new ArrayList<>();

		if(module.equals("0")) {
			//返回sys_file_relation表
			shardingResults.add("sys_file_relation");
		}else if(module.equals("1")) {
			//返回sys_file_relation_N表
			long rem=customerId%4;
			shardingResults.add("sys_file_relation_"+rem);
		}
		
		return shardingResults;
	}

}
