package testservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import testservice.controller.TaskController;
import testservice.data.JdbcTaskRepository;
import testservice.data.Task;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	JdbcTaskRepository repository;

	@Async
	@Override
	public CompletableFuture<String> execute(Task newtask) throws InterruptedException {
		    repository.insertTask(newtask);
			newtask.setStatus("RUNNING");
			newtask.setTimestamp(LocalDateTime.now().toString());
			repository.updateTaskStatus(newtask);
			Thread.sleep(30000);
			newtask.setStatus("FINISHED");
			newtask.setTimestamp(LocalDateTime.now().toString());
			repository.updateTaskStatus(newtask);
			return CompletableFuture.completedFuture("done");
	}

	@Override
	public Task findTask(String id) throws TaskController.NotFoundException, TaskController.BadRequestException {
			checkUUID(id);
			try {
				return repository.selectTask(id);
			} catch (EmptyResultDataAccessException exception) {
				throw new TaskController.NotFoundException();
			}
	}

	public void checkUUID(String id) {
		try{
			UUID uuid = UUID.fromString(id);
		} catch (IllegalArgumentException exception){
			throw new TaskController.BadRequestException();
		}
	}

}
