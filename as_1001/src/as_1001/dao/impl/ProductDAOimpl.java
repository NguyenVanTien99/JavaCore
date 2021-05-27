package as_1001.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import as_1001.common.DBUtils;
import as_1001.common.SQLCommand;
import as_1001.dao.ProductDao;
import as_1001.entities.Product;

public class ProductDAOimpl implements ProductDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;

	@Override
	public List<Product> getAllProducts() throws SQLException {

		List<Product> products = new ArrayList<Product>();
		
		connection = DBUtils.getInstance().getConnection();
		
		preparedStatement = connection.prepareStatement(SQLCommand.PRODUCT_QUERY_GET_ALL);
		
		results = preparedStatement.executeQuery();
		
		while (results.next()) {
			Product product = new Product();
			
			product.setProductId(results.getInt(1));
			product.setProductName(results.getString(2));
			product.setListPrice(results.getDouble(3));
			
			products.add(product);
			
		}

		return products;

	}
	
	public static void main(String[] args) {
		ProductDAOimpl productDAOimpl = new ProductDAOimpl();
		
		List<Product> products = new ArrayList<Product>();
		
	
		try {
			products = productDAOimpl.getAllProducts();
			
			for (Product product : products) {
				System.out.println(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
