package as_1001.dao;

import java.sql.SQLException;
import java.util.List;

import as_1001.entities.Employee;

public interface EmployeeDAO {
	List<Employee> getAllEmployees() throws SQLException;
}
