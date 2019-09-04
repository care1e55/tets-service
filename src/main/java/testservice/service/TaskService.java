package testservice.service;

import testservice.data.Task;

import java.util.concurrent.CompletableFuture;

public interface TaskService {
	public CompletableFuture<String> execute(Task task);
}
