package as_1001.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import as_1001.common.DBUtils;
import as_1001.common.SQLCommand;
import as_1001.dao.LineitemDAO;
import as_1001.entities.LineItem;

public class LineitemDAOimpl implements LineitemDAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;

	@Override
	public List<LineItem> getAllItemsByOrderId(int orderId) throws SQLException {
		List<LineItem> lineItems = new ArrayList<LineItem>();

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.LINEITEM_QUERY_FIND_BY_ORDER);

			preparedStatement.setInt(1, orderId);

			results = preparedStatement.executeQuery();

			while (results.next()) {
				LineItem lineItem = new LineItem();
				lineItem.setOrderId(results.getInt(1));
				lineItem.setProductId(results.getInt(2));
				lineItem.setQuantityId(results.getInt(3));
				lineItem.setPrice(results.getInt(4));

				lineItems.add(lineItem);
			}
		} finally {
			DBUtils.closeConnection(connection, preparedStatement, results);
		}

		return lineItems;
	}

	@Override
	public boolean addLineItem(LineItem item) throws SQLException {
		int result;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.LINEITEM_QUERY_ADD);

			preparedStatement.setInt(1, item.getOrderId());
			preparedStatement.setInt(2, item.getProductId());
			preparedStatement.setInt(3, item.getQuantityId());
			preparedStatement.setDouble(4, item.getPrice());

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

//	public static void main(String[] args) {
//
//		LineitemDAOimpl lineitemDAOimpl = new LineitemDAOimpl();
//
//		LineItem lineItem = new LineItem(19,2,9,2000);
//
//		try {
//			System.out.println(lineitemDAOimpl.addLineItem(lineItem));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
