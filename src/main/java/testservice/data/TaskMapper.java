package testservice.data;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {

		Task task = new Task();
		task.setId(rs.getString("ID"));
		task.setTimestamp(rs.getString("TIMESTAMP"));
		task.setStatus(rs.getString("STATUS"));

		return task;
	}

}
