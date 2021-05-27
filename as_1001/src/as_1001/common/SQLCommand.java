package as_1001.common;

public class SQLCommand {
	public static String CUSTOMER_QUERY_FIND_ALL_HAVE_ORDER = "SELECT c.customer_id,c.customer_name FROM Customer c WHERE c.customer_id IN (SELECT customer_id FROM Orders) ";
	public static String CUSTOMER_QUERY_FIND_ALL = "SELECT * FROM Customer";
	public static String ORDER_QUERY_FIND_BY_CUSTOMER = "SELECT * FROM Orders Where customer_id = ?";
	public static String LINEITEM_QUERY_FIND_BY_ORDER = "SELECT * FROM LineItem where order_id = ?";
	public static String COMPUTE_ORDER_TOTAL = "SELECT SUM(quantity * price) as total_price FROM LineItem where order_id = ? GROUP BY order_id";
	public static String ORDER_QUERY_ADD = "INSERT INTO Orders VALUES (?,?,?,?,?)";
	public static String EMPLOYEE_QUERY_GET_ALL = "SELECT * FROM employee";
	public static String ORDER_QUERY_FIND_ALL = "SELECT * FROM Orders";
	public static String LINEITEM_QUERY_ADD = "INSERT INTO LineItem VALUES (?,?,?,?)";
	public static String ORDER_QUERY_ADD_UPDATE_TOTAL = "UPDATE Orders SET total = ? WHERE order_id = ?";
	public static String PRODUCT_QUERY_GET_ALL = "SELECT * FROM product";
	
}
 