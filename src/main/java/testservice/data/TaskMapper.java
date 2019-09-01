package testservice.data;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {

		Task task = new Task();
		task.setId(rs.getObject("ID", java.util.UUID.class));
		task.setTimestamp(rs.getTimestamp("TIMESTAMP").toLocalDateTime());
		task.setStatus(rs.getString("STATUS"));

		return task;
	}

}
