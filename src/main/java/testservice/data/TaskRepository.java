package testservice.data;

import java.util.UUID;

public interface TaskRepository {
	Task insertTask(Task id);
	Task selectTask(UUID id);
	String selectTasks();
}
