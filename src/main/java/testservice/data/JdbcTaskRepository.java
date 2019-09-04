package testservice.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class JdbcTaskRepository implements TaskRepository {

	private JdbcTemplate template;

	@Autowired
	public JdbcTaskRepository(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}

	@Override
	public Task insertTask(Task task) {
		String sqlStr = "insert into tasks(id, timestamp, status) values(?,?,?)";
		template.update(sqlStr,
				task.getId(),
				task.getTimestamp(),
				task.getStatus());
		return task;
	}

	@Override
	public Task updateTaskStatus(Task task) {
		String sqlStr = "update tasks set status = ?, timestamp = ? where id = ?";
		template.update(sqlStr,
				task.getStatus(),
				task.getTimestamp(),
				task.getId());
		return task;
	}

	@Override
	public List<Task> selectTasks() {
		String sqlStr = "select	* from tasks";
		List<Task> tasks = template.query(sqlStr, new TaskMapper());
		return tasks;
	}

	@Override
	public Task selectTask(String id) {
		String sqlStr = "select	* from tasks where id=?";
		return template.queryForObject(sqlStr, new TaskMapper(), id);
	}

}
