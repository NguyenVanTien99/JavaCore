package training.util;

public class SQLCommand {
	public static String BILL_QUERY_FIND_ALL = "SELECT b.*, t.total_price FROM Bill b LEFT JOIN (\n"
			+ " SELECT bill_code, SUM(quantity * price) AS total_price\n" + " FROM item\n" + " GROUP BY bill_code\n"
			+ ") t ON b.bill_code = t.bill_code";
	public static String BILL_QUERY_ADD = "INSERT INTO Bill(bill_code, customer_name, created_date, discount) "
			+ " VALUES (?, ?, ?, ?)\n" + "SELECT @@ROWCOUNT";
	public static String BILL_QUERY_DELETE = "IF EXISTS (SELECT * FROM Item WHERE bill_code = ?)\n"
			+ " DELETE FROM Item WHERE bill_code = ?\n" + "DELETE FROM Bill WHERE bill_code = ?\n"
			+ "SELECT @@ROWCOUNT";
	public static String BILL_QUERY_FIND_BY_CODE = "SELECT b.*, t.total_price\n" + "FROM Bill b LEFT JOIN (\n"
			+ " SELECT bill_code, SUM(quantity * price) AS total_price\n" + " FROM item\n" + " GROUP BY bill_code\n"
			+ ") t ON b.bill_code = t.bill_code\n" + "WHERE b.bill_code = ?";
	public static String BILL_QUERY_FIND_BY_CUSTOMER_NAME = "SELECT b.*, t.total_price\n" + "FROM Bill b LEFT JOIN (\n"
			+ " SELECT bill_code, SUM(quantity * price) AS total_price\n" + " FROM item\n" + " GROUP BY bill_code\n"
			+ ") t ON b.bill_code = t.bill_code\n" + "WHERE b.customer_name = ?";
	public static String ITEM_QUERY_FIND_ALL = "SELECT * FROM Item WHERE bill_code = ?";
	public static String ITEM_QUERY_ADD = "INSERT INTO Item(product_name, bill_code, quantity, price) "
			+ "VALUES (?, ?, ?, ?)";
	public static String ITEM_QUERY_DELETE = "DELETE FROM Item WHERE bill_code = ? AND product_name = ?";
	public static String ITEM_QUERY_FIND_CODE_AND_PRODUCT_NAME = "SELECT * FROM Item WHERE bill_code = ? AND product_name = ?";
}
