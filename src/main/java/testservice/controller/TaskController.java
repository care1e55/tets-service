package testservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testservice.data.JdbcTaskRepository;
import testservice.data.Task;
import testservice.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

@RestController()
public class TaskController {

	@Autowired
	JdbcTaskRepository repository;

	@Autowired
	TaskService taskService;

//	@RequestMapping(value = "/callable", method= RequestMethod.GET, produces = "text/html")
//	public Callable<String> exec() {
//		System.out.println("begin");
//		Callable<String> callable = taskService::execute;
//		System.out.println("end");
//		return callable;
//	}

	@RequestMapping(value = "/callable", method= RequestMethod.GET, produces = "text/html")
	public String exec() {
		System.out.println("begin");
		CompletableFuture<String> employeeAddress = taskService.execute();
		System.out.println("end");
		return "execed";
	}


	@RequestMapping(value = "/task", method= RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Task createTask() {
		Task newtask = new Task(UUID.randomUUID().toString(), LocalDateTime.now().toString(), "CREATED");
		return repository.insertTask(newtask);
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
