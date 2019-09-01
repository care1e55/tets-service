package testservice.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
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
		String sqlStr = "insert into tasks";
//		return template.;
		return null;
	}

	@Override
	public List<Task> selectTasks() {
		String sqlStr = "select	* from tasks";
		List<Task> tasks = template.query(sqlStr, new TaskMapper());
		return tasks;
//		return null;
	}

	@Override
	public Task selectTask(UUID id) {
		String sqlStr = "select	* from tasks where id=?";
		return template.queryForObject(sqlStr, new TaskMapper(), id);
//		return null;
	}


}
