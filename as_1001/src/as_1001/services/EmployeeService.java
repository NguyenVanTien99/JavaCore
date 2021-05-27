package as_1001.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import as_1001.dao.EmployeeDAO;
import as_1001.dao.impl.EmployeeDAOimpl;
import as_1001.entities.Employee;

public class EmployeeService {
	private static EmployeeDAO employeeDAO = new EmployeeDAOimpl();

	public static void getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		try {
			employees = employeeDAO.getAllEmployees();
		} catch (SQLException e) {
			System.out.println("found");
		}
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	public static boolean checkEmployeeIdExist(int id) {
		List<Employee> employees = new ArrayList<Employee>();

		boolean check = true;

		try {
			employees = employeeDAO.getAllEmployees();
		} catch (SQLException e) {
			System.out.println("found");
		}
		for (Employee employee : employees) {
			if (employee.getEmployeeId() == id) {
				check = false;
				break;
			}
		}
		return check;

	}
}
