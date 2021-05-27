package as_1001.dao;

import java.sql.SQLException;
import java.util.List;

import as_1001.entities.LineItem;

public interface LineitemDAO {
	List<LineItem> getAllItemsByOrderId(int orderId) throws SQLException;
	boolean addLineItem(LineItem item) throws SQLException;
}
