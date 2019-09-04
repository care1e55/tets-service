package testservice.service;

import testservice.controller.TaskController;
import testservice.data.Task;

import java.util.concurrent.CompletableFuture;

public interface TaskService {
	public CompletableFuture<String> execute(Task task) throws Exception;
	public Task findTask(String id) throws TaskController.BadRequestException, TaskController.NotFoundException;
}
