package com.sdstc.activiti.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.BaseSerStart;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BaseSerStart.class })
@Log4j2
class ActServiceImplTest {
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;

	// 部署bpmn
	@Test
	void deploment() throws FileNotFoundException, IOException {
		String content = IOUtils.toString(new FileInputStream("d://process.bpmn"), "UTF-8");
		content=content.replaceAll("camunda:assignee=", "activiti:assignee=");
		
		Deployment deployment = repositoryService.createDeployment().addString("process.bpmn", content).name("testProccess").deploy();

		log.info("流程部署id:" + deployment.getName());
		log.info("流程部署名称:" + deployment.getId());

	}
	
	//启动流程
	@Test
	void startProcess() {
		// xml中定义的ID
		String instanceKey = "process";
		log.info("开启请假流程...");

		// 设置流程参数，开启流程
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobNumber", "A1001");
		map.put("busData", "bus data");
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(instanceKey, map);// 使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动

		log.info("启动流程实例成功:{}", instance);
		log.info("流程实例ID:{}", instance.getId());
		log.info("流程定义ID:{}", instance.getProcessDefinitionId());

		// 验证是否启动成功
		// 通过查询正在运行的流程实例来判断
		ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();
		// 根据流程实例ID来查询
		List<ProcessInstance> runningList = processInstanceQuery.processInstanceId(instance.getProcessInstanceId()).list();
		log.info("根据流程ID查询条数:{}", runningList.size());

		// 返回流程ID
		log.info(instance.getId());
	}

	//完成任务
	@Test
	void complateTask() {
		List<Task> tasks=taskService.createTaskQuery().taskAssignee("gang").list();
		if(tasks.size()>0) {
			taskService.complete(tasks.get(0).getId());
		}
		
	}

}
