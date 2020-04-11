package com.sdstc.activiti.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.activiti.service.ActService;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author cheng
 *
 */
@Service("actService")
@Log4j2
public class ActServiceImpl implements ActService {
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;

	@Override
	public Deployment deploment(String resourceName, String depName, String content) throws FileNotFoundException, IOException {
		// String content = IOUtils.toString(new FileInputStream("d://process.bpmn"),"UTF-8");
		log.info("deploment");
		// 将设计器中的部分字段替换
		content = content.replaceAll("camunda:assignee=", "activiti:assignee=");
		Deployment deployment = repositoryService.createDeployment().addString(resourceName, content).name(depName).deploy();
		return deployment;
	}

	@Override
	public ProcessInstance startProcess(String processDefinitionKey, Map<String, Object> variables) {
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
		return instance;
	}

	@Override
	public void complateTask(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId, variables);
	}
}
