package as_1001.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import as_1001.common.DBUtils;
import as_1001.common.SQLCommand;
import as_1001.dao.EmployeeDAO;
import as_1001.entities.Employee;

public class EmployeeDAOimpl implements EmployeeDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.EMPLOYEE_QUERY_GET_ALL);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(results.getInt(1));
				employee.setEmployeeName(results.getString(2));
				employee.setSalary(results.getDouble(3));
				employee.setSpvrId(results.getInt(4));

				employees.add(employee);
			}
		} finally {
			DBUtils.closeConnection(connection, preparedStatement, results);
		}
		
		return employees;
	}
	
}
