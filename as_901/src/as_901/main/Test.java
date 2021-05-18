package as_901.main;

import java.io.IOException;

import java.util.List;
import java.util.Scanner;

import as_901.entities.Customer;

import as_901.services.CustomerService;
import as_901.utils.Constants;

public class Test {

	private static List<Customer> listNewCustomers;
	private static List<Customer> listCustomers;


	public static void main(String[] args) {
		String choice, phone;
		Scanner scanner = new Scanner(System.in);

		CustomerService customerService = new CustomerService();

		do {
			System.out.println("-----------Customer ManagementFactory ---------------");
			System.out.println("1.Add new Customer");
			System.out.println("2.Show All customer");
			System.out.println("3.Search customer by phone number");
			System.out.println("4.Remove customer By phone number");
			System.out.println("Exit");
			System.out.println("------------------------------------------------------");
			System.out.print("please Select: ");
			choice = scanner.nextLine();
			choice = choice.trim();

			switch (choice) {
			case Constants.INPUT:
				
				try {
					listCustomers = customerService.getAll();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				listNewCustomers = customerService.createCustomer(scanner);
				
				listCustomers.addAll(listNewCustomers);

				try {
					customerService.save(listCustomers);
					System.out.println("Input done!");
				} catch (Exception e) {
					System.out.println("Succes");
				}

				break;

			case Constants.SHOW:

				try {
					customerService.display();
				} catch (IOException e) {
					System.out.println("No data");
				}

				break;

			case Constants.SEARCH:
				System.out.println("Enter the phone number: ");
				phone = scanner.nextLine();
				try {
					customerService.getOrderByPhone(phone);
				} catch (IOException e) {
					System.out.println("No data");
				}
				break;

			case Constants.REMOVE:
				System.out.println("Enter the phone number: ");
				phone = scanner.nextLine();
				try {
					System.out.println(customerService.remove(phone));

				} catch (Exception e) {
					System.out.println("No data");
				}
				break;

			default:
				choice = Constants.EXIT;
				break;
			}

		} while (!choice.equalsIgnoreCase(Constants.EXIT));

	}
}
