package testservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import testservice.data.Task;
import testservice.data.TaskRepository;

import java.time.LocalDateTime;
import java.util.UUID;

//@RestController("/tasks")
public class StatusController {

	@Autowired
	TaskRepository tr;


//	@RequestMapping(method=RequestMethod.GET)
//	public Task getTask() {
//		return new Task(UUID.randomUUID(), LocalDateTime.now(),
//				"created");
//	}

//	@RequestMapping(method=RequestMethod.GET)
//	public String getTask() {
//		return tr.selectTasks();
//	}

}
