package as_1001.dao;

import java.sql.SQLException;
import java.util.List;

import as_1001.entities.Customer;

public interface CustomerDAO {
	List<Customer> selectAllCustomer() throws SQLException;
	List<Customer> getAllCustomer() throws SQLException;
	boolean addCustomer(Customer customer) throws SQLException;
	boolean deleteCustomer(int customerId) throws SQLException;
	boolean updateCustomer(Customer customer) throws SQLException;
	
} 
