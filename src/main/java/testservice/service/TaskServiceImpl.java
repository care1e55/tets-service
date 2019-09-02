package testservice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TaskServiceImpl implements TaskService {

	@Async
	@Override
	public CompletableFuture<String> execute() {
		try {
			Thread.sleep(5000);
			System.out.println("Slow task executed");
			return CompletableFuture.completedFuture("kek");
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}
}
