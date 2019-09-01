package testservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import testservice.data.Task;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController()
public class TaskController {

	@RequestMapping(value = "/task", method= RequestMethod.GET)
	public Task createTask() {
		return new Task(UUID.randomUUID(), LocalDateTime.now(),
				"created");
	}

}
