package testservice.service;

import java.util.concurrent.CompletableFuture;

public interface TaskService {
	public CompletableFuture<String> execute();
}
