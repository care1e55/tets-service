package testservice.data;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {
	Task insertTask(Task id);
	Task selectTask(String id);
	List<Task> selectTasks();
	Task updateTaskStatus(Task task);
}
