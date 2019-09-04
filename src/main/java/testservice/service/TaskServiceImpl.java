package testservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import testservice.data.JdbcTaskRepository;
import testservice.data.Task;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	JdbcTaskRepository repository;

	@Async
	@Override
	public CompletableFuture<String> execute(Task newtask) {
		try {
			repository.insertTask(newtask);
			newtask.setStatus("RUNNING");
			newtask.setTimestamp(LocalDateTime.now().toString());
			repository.updateTaskStatus(newtask);
			Thread.sleep(30000);
			newtask.setStatus("FINISHED");
			newtask.setTimestamp(LocalDateTime.now().toString());
			repository.updateTaskStatus(newtask);
			return CompletableFuture.completedFuture("kek");
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}
}
