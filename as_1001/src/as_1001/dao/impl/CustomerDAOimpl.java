package as_1001.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import as_1001.common.DBUtils;
import as_1001.common.SQLCommand;
import as_1001.dao.CustomerDAO;
import as_1001.entities.Customer;

public class CustomerDAOimpl implements CustomerDAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	private CallableStatement callableStatement = null;

	@Override
	public List<Customer> getAllCustomer() throws SQLException {

		List<Customer> customers = new ArrayList<Customer>();
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.CUSTOMER_QUERY_FIND_ALL_HAVE_ORDER);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(results.getInt(1));
				customer.setCustomerName(results.getString(2));

				customers.add(customer);
			}
		} finally {
			DBUtils.closeConnection(connection, preparedStatement, results);
		}
		return customers;
	}

	@Override
	public boolean addCustomer(Customer customer) throws SQLException {
		String result;

		try {
			connection = DBUtils.getInstance().getConnection();
			callableStatement = connection.prepareCall("{CALL PROCEDURE_CustomerInsert(?,?,?)}");
			callableStatement.setInt(1, customer.getCustomerId());
			callableStatement.setString(2, customer.getCustomerName());
			callableStatement.registerOutParameter(3, Types.VARCHAR);
			callableStatement.execute();

			result = callableStatement.getString(3);
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		if (result.equals("success")) {
			return true;
		}

		return false;

	}

	@Override
	public boolean deleteCustomer(int customerId) throws SQLException {
		String result;

		try {
			connection = DBUtils.getInstance().getConnection();
			callableStatement = connection.prepareCall("{CALL PROCEDURE_CustomerDelete(?,?)}");
			callableStatement.setInt(1, customerId);
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			callableStatement.execute();

			result = callableStatement.getString(2);
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		if (result.equals("success")) {
			return true;
		}

		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) throws SQLException {

		String result;

		try {
			connection = DBUtils.getInstance().getConnection();
			callableStatement = connection.prepareCall("{CALL PROCEDURE_CustomerUpdate(?,?,?)}");
			callableStatement.setInt(1, customer.getCustomerId());
			callableStatement.setString(2, customer.getCustomerName());
			callableStatement.registerOutParameter(3, Types.VARCHAR);
			callableStatement.execute();

			result = callableStatement.getString(3);
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		if (result.equals("success")) {
			return true;
		}

		return false;
	}
	
	public static void main(String[] args) {
		CustomerDAOimpl customerDAOimpl = new CustomerDAOimpl();
		
		try {
			customerDAOimpl.deleteCustomer(10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> selectAllCustomer() throws SQLException {

		List<Customer> customers = new ArrayList<Customer>();
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.CUSTOMER_QUERY_FIND_ALL);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(results.getInt(1));
				customer.setCustomerName(results.getString(2));

				customers.add(customer);
			}
		} finally {
			DBUtils.closeConnection(connection, preparedStatement, results);
		}
		return customers;
	}
	


}
