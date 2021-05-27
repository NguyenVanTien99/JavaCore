package as_1001.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import as_1001.common.DBUtils;
import as_1001.common.SQLCommand;
import as_1001.common.Validator;
import as_1001.dao.OrderDAO;
import as_1001.entities.Order;

public class OrderDAOimpl implements OrderDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet results;

	@Override
	public List<Order> getAllOrdersByCustomerId(int customerId) throws SQLException {
		List<Order> orders = new ArrayList<Order>();
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.ORDER_QUERY_FIND_BY_CUSTOMER);

			preparedStatement.setInt(1, customerId);

			results = preparedStatement.executeQuery();

			while (results.next()) {
				Order order = new Order();

				order.setOderId(results.getInt(1));
				order.setOderDate(results.getString(2));
				order.setCustomerId(results.getInt(3));
				order.setEmployeeId(results.getInt(4));
				order.setTotal(results.getDouble(5));

				orders.add(order);
			}
		} finally {
			DBUtils.closeConnection(connection, preparedStatement, results);
		}

		return orders;
	}

	@Override
	public Double computeOrderTotal(int orderId) throws SQLException {
		double total;

		connection = DBUtils.getInstance().getConnection();
		preparedStatement = connection.prepareStatement(SQLCommand.COMPUTE_ORDER_TOTAL);

		preparedStatement.setInt(1, orderId);

		results = preparedStatement.executeQuery();

		results.next();

		total = results.getDouble(1);
		return total;
	}

	@Override
	public boolean addOrder(Order order) throws SQLException {
		int result;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.ORDER_QUERY_ADD);

			preparedStatement.setInt(1, order.getOderId());
			preparedStatement.setString(2, order.getOderDate());
			preparedStatement.setInt(3, order.getCustomerId());
			preparedStatement.setInt(4, order.getEmployeeId());
			preparedStatement.setDouble(5, order.getTotal());

			result = preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		if (result > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean updateOrderTotal(int orderId) throws SQLException {
		int result;
		
		Scanner scanner = new Scanner(System.in);
		
		double total;
		
		System.out.println("Enter the total you want update");

		do {
			String idString = scanner.nextLine();
			try {
				total = Validator.isDouble(idString);
			} catch (NumberFormatException e) {
				System.out.println("value is number");
				continue;
			}
			break;
		} while (true);

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.ORDER_QUERY_ADD_UPDATE_TOTAL);

			preparedStatement.setDouble(1, total);
			preparedStatement.setInt(2, orderId);
			result = preparedStatement.executeUpdate();
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		if (result > 0) {
			return true;
		}

		return false;
	}

	@Override
	public List<Order> getAllOrders() throws SQLException {
		List<Order> orders = new ArrayList<Order>();
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.ORDER_QUERY_FIND_ALL);

			results = preparedStatement.executeQuery();

			while (results.next()) {
				Order order = new Order();

				order.setOderId(results.getInt(1));
				order.setOderDate(results.getString(2));
				order.setCustomerId(results.getInt(3));
				order.setEmployeeId(results.getInt(4));
				order.setTotal(results.getDouble(5));

				orders.add(order);
			}
		} finally {
			DBUtils.closeConnection(connection, preparedStatement, results);
		}

		return orders;
	}
	
//	public static void main(String[] args) {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
//		Date date = new Date();
//		System.out.println(formatter.format(date));
//
//		OrderDAOimpl orderDAOimpl = new OrderDAOimpl();
//
//		Order order = new Order(20,formatter.format(date),2,4,2000);
//
//		try {
//		System.out.println(orderDAOimpl.updateOrderTotal(19));	
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
