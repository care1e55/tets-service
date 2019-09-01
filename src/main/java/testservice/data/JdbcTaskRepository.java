package testservice.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
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
	public String selectTasks() {
		String sqlStr = "select	* from tasks";
//		return template.queryForList(sqlStr);
		return sqlStr;
	}

	@Override
	public Task selectTask(UUID id) {
//		String sqlStr = "select	* from tasks where id=?";
////		return template.queryForObject(sqlStr, RowMapper<Employee>(){
////			@Override
////			public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
////				Employee e=new Employee();
////				e.setId(rs.getInt(1));
////				e.setName(rs.getString(2));
////				e.setSalary(rs.getInt(3));
////				return e; },
////			id);
		return null;
	}


}
