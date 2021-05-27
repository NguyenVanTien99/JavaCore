package as_1001.dao;

import java.sql.SQLException;
import java.util.List;

import as_1001.entities.Order;

public interface OrderDAO {
	List<Order> getAllOrdersByCustomerId(int customerId) throws SQLException;
	List<Order> getAllOrders() throws SQLException;
	Double computeOrderTotal(int orderId) throws SQLException;
	boolean addOrder(Order order) throws SQLException;
	boolean updateOrderTotal(int orderId) throws SQLException;
}
