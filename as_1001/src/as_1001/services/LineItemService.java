package as_1001.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import as_1001.common.Validator;
import as_1001.dao.LineitemDAO;
import as_1001.dao.impl.LineitemDAOimpl;
import as_1001.entities.LineItem;

public class LineItemService {
	private static LineitemDAO lineitemDAO = new LineitemDAOimpl();

	public static void getAllItemsByOrderId(Scanner scanner) {
		System.out.println("Enter the order id: ");

		int id;

		do {
			String idString = scanner.nextLine();
			try {
				id = Validator.isInt(idString);
			} catch (NumberFormatException e) {
				System.out.println("value is number");
				continue;
			}
			break;
		} while (true);
		List<LineItem> lineItems = null;
		try {
			lineItems = lineitemDAO.getAllItemsByOrderId(id);
		} catch (SQLException e) {
			System.out.println("SQL Found");
		}

		if (lineItems.isEmpty()) {
			System.out.println("No data Found");
		} else {
			System.out.println("---list All line item by oderid");
			lineItems.stream().forEach(System.out::println);
		}

	}

	public static void addLineItem(Scanner scanner) {
		LineItem lineItem = new LineItem();

		OrderService.getAllOrders();

		do {
			System.out.println("Enter the id Order");

			String idString = scanner.nextLine();

			try {
				if (OrderService.checkOrderidExist(Validator.isInt(idString))) {
					System.out.println("not found order");
					continue;
				}

				lineItem.setOrderId(Validator.isInt(idString));

			} catch (NumberFormatException e) {
				System.out.println("Number is value");
				continue;
			}

			break;
		} while (true);
		ProductService.getAllProducts();

		do {

			System.out.println("Enter the id products");

			String idString = scanner.nextLine();

			try {
				if (ProductService.checkProductIdExist(Validator.isInt(idString))) {
					System.out.println("not Found product");
					continue;
				}

				lineItem.setProductId(Validator.isInt(idString));

			} catch (NumberFormatException e) {
				System.out.println("Number is value");
				continue;
			}

			break;
		} while (true);

		do {

			System.out.println("Enter the quanntity: ");

			String quanlityString = scanner.nextLine();

			try {

				lineItem.setQuantityId(Validator.isInt(quanlityString));

			} catch (NumberFormatException e) {
				System.out.println("Number is value");
				continue;
			}
			break;
		} while (true);

		do {

			System.out.println("Enter the price: ");

			String priceString = scanner.nextLine();

			try {

				lineItem.setPrice(Validator.isDouble(priceString));

			} catch (NumberFormatException e) {
				System.out.println("Number is value");
				continue;
			}
			break;
		} while (true);

		try {
			lineitemDAO.addLineItem(lineItem);
			System.out.println("add sucess");
		} catch (SQLException e) {
			System.out.println("Id order and id product is super key");
		}
	}



}
