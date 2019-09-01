package testservice.data;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {
	Task insertTask(Task id);
	Task selectTask(UUID id);
	List<Task> selectTasks();
}
