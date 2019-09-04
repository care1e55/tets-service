package testservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testservice.data.JdbcTaskRepository;
import testservice.data.Task;
import testservice.service.TaskService;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController()
public class TaskController {

	@Autowired
	JdbcTaskRepository repository;

	@Autowired
	TaskService taskService;

	@RequestMapping(value = "/callable", method= RequestMethod.GET, produces = "text/html")
	public String exec() {
		System.out.println("begin");
//		CompletableFuture<String> employeeAddress = taskService.execute();
		System.out.println("end");
		return "execed";
	}


	@RequestMapping(value = "/task", method= RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String createTask() {
		Task newtask = new Task(UUID.randomUUID().toString(), LocalDateTime.now().toString(), "CREATED");
		CompletableFuture<String> employeeAddress = taskService.execute(newtask);
		return newtask.getId();
	}

	@RequestMapping(value = "/task/{id}", method= RequestMethod.GET)
	public Task showTask(@PathVariable("id") String id) {
		return repository.selectTask(id);
	}

	@RequestMapping(value = "/tasks", method= RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Iterable<Task>> showTasks() {
		return new ResponseEntity<Iterable<Task>>(repository.selectTasks(), HttpStatus.OK);
	}

}
