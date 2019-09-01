package testservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testservice.data.JdbcTaskRepository;
import testservice.data.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController()
public class TaskController {

	@Autowired
	JdbcTaskRepository repository;

	@RequestMapping(value = "/task", method= RequestMethod.GET)
	public Task createTask() {
		return new Task(UUID.randomUUID(), LocalDateTime.now(),
				"created");
	}

	@RequestMapping(value = "/tasks", method= RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Iterable<Task>> showTasks() {
		return new ResponseEntity<Iterable<Task>>(repository.selectTasks(), HttpStatus.OK);
//		return repository.selectTasks();
//		return null;
	}

}
