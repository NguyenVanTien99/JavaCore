package as_1001.services;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import as_1001.common.Validator;
import as_1001.dao.OrderDAO;
import as_1001.dao.impl.OrderDAOimpl;
import as_1001.entities.Order;

public class OrderService {
	private static OrderDAO orderDAO = new OrderDAOimpl();

	public static void getAllOrdersByCustomerId(Scanner scanner) {
		System.out.println("Enter the customer id: ");

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

		List<Order> orders = null;

		try {
			orders = orderDAO.getAllOrdersByCustomerId(id);
		} catch (SQLException e) {
			System.out.println("SQL Found");
		}

		if (orders.isEmpty()) {
			System.out.println("No data Found");
		} else {
			System.out.println("---list All order by customer");
			orders.stream().forEach(System.out::println);
		}

	}

	public static void computeOrderTotal(Scanner scanner) {
		System.out.println("Enter the customer id: ");

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

		double total = 0;
		try {
			total = orderDAO.computeOrderTotal(id);
		} catch (SQLException e) {
			System.out.println("SQL Found");
		}

		System.out.println("total " + total);
	}

	public static void addOrder(Scanner scanner) {

		Order order = new Order();

		do {
			System.out.println("Enter the id Order");

			String idString = scanner.nextLine();

			try {
				if (checkOrderidExist(Validator.isInt(idString)) == false) {
					System.out.println("id is exist");
					continue;
				}

				order.setOderId(Validator.isInt(idString));

			} catch (NumberFormatException e) {
				System.out.println("Number is value");
				continue;
			}

			break;
		} while (true);

		CustomerService.displayAllCustomer();

		do {

			System.out.println("Enter the id customer");

			String idString = scanner.nextLine();

			try {
				if (CustomerService.checkIdCustomerExist(Validator.isInt(idString))) {
					System.out.println("not Found customer");
					continue;
				}

				order.setCustomerId(Validator.isInt(idString));

			} catch (NumberFormatException e) {
				System.out.println("Number is value");
				continue;
			}

			break;
		} while (true);

		EmployeeService.getAllEmployees();

		do {

			System.out.println("Enter the id employee ");

			String idString = scanner.nextLine();

			try {

				if (EmployeeService.checkEmployeeIdExist(Validator.isInt(idString))) {
					System.out.println("not Found employee");
					continue;
				}

				order.setEmployeeId(Validator.isInt(idString));

			} catch (NumberFormatException e) {
				System.out.println("Number is value");
				continue;
			}
			break;
		} while (true);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		order.setOderDate(formatter.format(date));

		do {
			System.out.println("Enter the total order");
			String totalString = scanner.nextLine();
			try {
				order.setTotal(Validator.isDouble(totalString));
			} catch (Exception e) {
				System.out.println("Value is number");
				continue;
			}
			break;
		} while (true);

		try {
			orderDAO.addOrder(order);
			System.out.println("add sucess");
		} catch (SQLException e) {
			System.out.println("SQL Found");
		}
	}

	public static void updateOrderTotal(Scanner scanner) {

		getAllOrders();
		int id;

		do {
			System.out.println("Enter the order id");
			String idString = scanner.nextLine();

			try {
				if (checkOrderidExist(Validator.isInt(idString))) {
					System.out.println("id is not Exist");
					continue;
				}

				id = Validator.isInt(idString);

			} catch (NumberFormatException e) {
				System.out.println("Value is number");
				continue;
			}

			break;
		} while (true);

		try {
			orderDAO.updateOrderTotal(id);
			System.out.println("Update success");
		} catch (SQLException e) {
			System.out.println("False");
		}
	}

	public static void getAllOrders() {
		List<Order> orders = new ArrayList<Order>();

		try {
			orders = orderDAO.getAllOrders();
		} catch (SQLException e) {
			System.out.println("false");
		}

		for (Order order : orders) {
			System.out.println(order);
		}
	}

	public static boolean checkOrderidExist(int id) {
		boolean check = true;

		List<Order> orders = new ArrayList<Order>();

		try {
			orders = orderDAO.getAllOrders();
		} catch (SQLException e) {
			System.out.println("false");
		}

		for (Order order : orders) {
			if (order.getOderId() == id) {
				check = false;
				break;
			}
		}

		return check;
	}

	public static void main(String[] args) {
		addOrder(new Scanner(System.in));
	}

}
