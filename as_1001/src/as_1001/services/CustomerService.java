package as_1001.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import as_1001.common.Validator;
import as_1001.dao.CustomerDAO;
import as_1001.dao.impl.CustomerDAOimpl;
import as_1001.entities.Customer;

public class CustomerService {
	private static CustomerDAO customerDAO = new CustomerDAOimpl();

	public static void getAllCustomer() {

		List<Customer> customers = new ArrayList<Customer>();

		try {
			customers = customerDAO.getAllCustomer();
		} catch (SQLException e) {
			System.out.println("Found SQL");
		}

		if (customers.isEmpty()) {
			System.out.println("No data Found");
		} else {
			System.out.println("---list All customer has order");
			customers.stream().forEach(System.out::println);
		}
	}

	public static void addCustomer(Scanner scanner) {
		List<Customer> customers = new ArrayList<Customer>();

		Customer customer = new Customer();

		int customerId;
		String customerName;

		do {

			try {
				customers = customerDAO.selectAllCustomer();
			} catch (SQLException e1) {
				System.out.println("found");
			}

			System.out.println("Enter the customer id");
			String id = scanner.nextLine();

			try {
				customerId = Validator.isInt(id);

				if (checkIdCustomerExist(customerId) == false) {
					System.out.println("id customer is exist");
					continue;
				}

			} catch (NumberFormatException e) {
				System.out.println("Number is value");
				continue;
			}
			break;
		} while (true);

		System.out.println("Enter the customer name");
		customerName = scanner.nextLine();

		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);

		try {
			if (customerDAO.addCustomer(customer)) {
				System.out.println("add sucess");
			}
		} catch (SQLException e) {
			System.out.println("False");
		}
	}

	public static void deleteCustomer(Scanner scanner) {

		int idCustomer;

		do {
			displayAllCustomer();

			System.out.println("Enter the id customer you want to delete");

			String idString = scanner.nextLine();

			try {
				idCustomer = Validator.isInt(idString);

				if (checkIdCustomerExist(idCustomer)) {
					System.out.println("not found customer");
					continue;
				}

			} catch (NumberFormatException e) {
				System.out.println("Number is value");
				continue;
			}
			break;
		} while (true);

		try {
			customerDAO.deleteCustomer(idCustomer);
			System.out.println("delete sucess");
		} catch (SQLException e) {
			System.out.println("False");
		}

	}

	public static void updateCustomer(Scanner scanner) {

		Customer customer = new Customer();

		int customerId;
		String customerName;

		do {

			displayAllCustomer();

			System.out.println("Enter the customer id you want to update");
			String id = scanner.nextLine();

			try {
				customerId = Validator.isInt(id);

				if (checkIdCustomerExist(customerId)) {
					System.out.println("not found customer");
					continue;
				}

			} catch (NumberFormatException e) {
				System.out.println("Number is value");
				continue;
			}
			break;
		} while (true);

		System.out.println("Enter the customer name");

		customerName = scanner.nextLine();

		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);

		try {
			if (customerDAO.updateCustomer(customer)) {
				System.out.println("update sucess");
			}
		} catch (SQLException e) {
			System.out.println("False");
		}
	}

	static void displayAllCustomer() {
		List<Customer> customers = new ArrayList<>();
		try {
			customers = customerDAO.selectAllCustomer();
		} catch (SQLException e1) {
			System.out.println("False");
		}
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

	static boolean checkIdCustomerExist(int id) {

		boolean check = true;

		List<Customer> customers = new ArrayList<>();
		try {
			customers = customerDAO.selectAllCustomer();
		} catch (SQLException e1) {
			System.out.println("False");
		}
		for (Customer customer : customers) {
			if (customer.getCustomerId() == id) {
				check = false;
				break;
			}
		}

		return check;
	}

}
