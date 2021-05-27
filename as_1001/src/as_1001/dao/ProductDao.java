package as_1001.dao;

import java.sql.SQLException;
import java.util.List;

import as_1001.entities.Product;

public interface ProductDao {
	List<Product> getAllProducts() throws SQLException;
}
