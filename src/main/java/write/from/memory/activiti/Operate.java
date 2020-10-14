package write.from.memory.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.task.Task;

public class Operate {

	ProcessEngine processEngine;

	public void createTable() {
		processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
				.buildProcessEngine();
	}

	public void disployFlow() {
		processEngine.getRepositoryService().createDeployment().name("HelloWorld").addClasspathResource("process.bpmn")
				.addClasspathResource("process.png").deploy();
	}

	public void startFlow() {
		processEngine.getRuntimeService().startProcessInstanceById("HelloWorldKey");
	}

	public void findPersonalTask() {
		List<Task> taskList = processEngine.getTaskService().createTaskQuery().taskAssignee("assign").list();
		for (Task task : taskList) {
			System.out.println(task.getAssignee());
		}
	}

	public void completeTask() {
		processEngine.getTaskService().complete("taskId");
	}
}
