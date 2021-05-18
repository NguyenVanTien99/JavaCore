package as_901.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import as_901.entities.Customer;
import as_901.entities.Order;
import as_901.utils.Constants;
import as_901.utils.PhoneException;

public class CustomerService {

	public List<Customer> createCustomer(Scanner scanner) {
		String loop, name, phone, address;

		List<Customer> customers = new ArrayList<>();

		List<Order> orders = new ArrayList<Order>();

		OrderService orderService = new OrderService();

		Customer customer;

		do {
			customer = new Customer();

			System.out.println("Enter the customer name");
			name = scanner.nextLine();
			customer.setName(name);

			System.out.println("Enter the customer address");
			address = scanner.nextLine();
			customer.setAddress(address);

			do {
				System.out.println("Enter the customer phone");
				phone = scanner.nextLine();
				try {
					customer.setPhone(phone);
				} catch (PhoneException e) {
					System.out.println(e.getMessage());
					continue;
				}

				break;
			} while (true);

			System.out.println("---------Enter the order of Customer------------");
			orders = orderService.createOrder(scanner);
			customer.setListOfOrder(orders);

			customers.add(customer);

			System.out.println("Do you want continue to input the Customer (Y/N)");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');


		return customers;

	}

	public String save(List<Customer> customers) throws Exception {
		ObjectOutputStream objectOutputStream = null;

		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(Constants.FILE_PATH));

			objectOutputStream.writeObject(customers);
		} catch (Exception e) {
			throw new Exception();
		} finally {
			if (objectOutputStream != null) {
				objectOutputStream.close();
			}
		}
		return Constants.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAll() throws IOException {
		ObjectInputStream objectInputStream = null;
		List<Customer> customers;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(Constants.FILE_PATH));
			customers = (List<Customer>) objectInputStream.readObject();
		} catch (Exception exception) {
			throw new IOException();
		} finally {
			if (objectInputStream != null) {
				objectInputStream.close();
			}
		}
		return customers;
	}

	public void display() throws IOException {
		List<Customer> customers = getAll();
		System.out.println(customers.size());
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

	public void getOrderByPhone(String phone) throws IOException {

		List<Customer> customers = getAll();

		for (Customer customer : customers) {
			if (customer.getPhone().equals(phone)) {
				System.out.println(customer.getListOfOrder());
			}
		}
	}

	public String remove(String phone) throws Exception {
		List<Customer> customers = getAll();
		boolean remove = false;

//		for (Customer customer : customers) {
//			if (customer.getPhone().equals(phone)) {
//				customers.remove(customer);
//				remove = true;
//			}
//		}
		
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getPhone().equals(phone)) {
				customers.remove(i);
				remove = true;
			}
		}

		if (remove) {
			try {
				save(customers);
			} catch (Exception e) {
				throw new Exception();
			}

			return Constants.SUCCESS;
		}

		return Constants.FAIL;

	}



}
