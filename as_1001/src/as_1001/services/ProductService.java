package as_1001.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import as_1001.dao.ProductDao;
import as_1001.dao.impl.ProductDAOimpl;
import as_1001.entities.Product;

public class ProductService {
	private static ProductDao productDao = new ProductDAOimpl();

	public static void getAllProducts() {
		List<Product> products = new ArrayList<>();

		try {
			products = productDao.getAllProducts();
		} catch (SQLException e) {
			System.out.println("found");
		}
		for (Product product : products) {
			System.out.println(product);
		}
	}

	public static boolean checkProductIdExist(int id) {
		List<Product> products = new ArrayList<>();

		boolean check = true;

		try {
			products = productDao.getAllProducts();
		} catch (SQLException e) {
			System.out.println("found");
		}
		for (Product product : products) {
			if (product.getProductId() == id) {
				check = false;
				break;
			}
		}
		return check;

	}
}
