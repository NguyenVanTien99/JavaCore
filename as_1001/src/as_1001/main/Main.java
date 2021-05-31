package as_1001.main;

import java.util.Scanner;

import as_1001.services.CustomerService;
import as_1001.services.LineItemService;
import as_1001.services.OrderService;

public class Main {
	public static void main(String[] args) {
		String choice = "";
		Scanner scanner = new Scanner(System.in);

		do {
			getmenu();

			System.out.println("Enter the choice: ");
			choice = scanner.nextLine();

			switch (choice) {
			case "1":
				CustomerService.getAllCustomer();
				break;

			case "2":
				OrderService.getAllOrdersByCustomerId(scanner);
				break;

			case "3":
				LineItemService.getAllItemsByOrderId(scanner);
				break;

			case "4":
				OrderService.computeOrderTotal(scanner);

				break;

			case "5":
				CustomerService.addCustomer(scanner);

				break;

			case "6":
				CustomerService.deleteCustomer(scanner);

				break;

			case "7":
				CustomerService.updateCustomer(scanner);

				break;

			case "8":
				OrderService.addOrder(scanner);
				break;
			case "9":
				LineItemService.addLineItem(scanner);
				break;
			case "10":
				OrderService.updateOrderTotal(scanner);
				break;

			default:
				choice = "N";
				break;			}
		} while (choice != "N");
	}

	public static void getmenu() {
		System.out.println("--------------Menu----------------");
		System.out.println("1.Display all customer has order");
		System.out.println("2.Display all order by customer Id");
		System.out.println("3.Display line item by order id ");
		System.out.println("4.Compute order total by order Id ");
		System.out.println("5.Add a customer ");
		System.out.println("6.Delete a customer ");
		System.out.println("7.Update a customer ");
		System.out.println("8.Create an order ");
		System.out.println("9.Create a lineitem ");
		System.out.println("10.Update an order total ");
	}

}
