package com.sdstc.activiti.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.repository.Deployment;

/**
 * 
 * @author cheng
 *
 */
public interface ActService {
	/**
	 * 模型部署
	 * @param resourceName
	 * @param depName
	 * @param content
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	Deployment  deploment(String resourceName,String depName,String content)throws FileNotFoundException, IOException ;
	
	/**
	 * 流程启动
	 * @param processDefinitionKey
	 * @param variables
	 * @return
	 */
	ProcessInstance startProcess(String processDefinitionKey, Map<String, Object> variables);
	
	/**
	 * 完成任务
	 * @param taskId
	 * @param variables
	 */
	void  complateTask(String taskId, Map<String, Object> variables);
}
