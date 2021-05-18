package as_901.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import as_901.entities.Order;
import as_901.utils.OrderException;

public class OrderService {
	
	public List<Order> createOrder(Scanner scanner){
		
		String loop, number, date;
		
		Order order;
		
		
		List<Order> orders = new ArrayList<Order>();
		
		do {
			order = new Order();
			
			do {
				System.out.println("+ Enter the oder number");
				number = scanner.nextLine();

				try {
					order.setNumber(number);

				} catch (OrderException e) {
					System.out.println(e.getMessage());
					continue;
				}
				break;
			} while (true);
			
			do {
				System.out.println("+ Enter the date number");
				date = scanner.nextLine();
				
				try {
					Date date1 =  new SimpleDateFormat("dd/MM/yyyy").parse(date);
					order.setDate(date1);
				} catch (ParseException e) {
					System.out.println("+ date is format dd/MM/yyyy");
					continue;
				}
				break;
			} while (true);
			
			orders.add(order);
		
			System.out.println("do you want continue to input order? (Y/N)");
			loop = scanner.nextLine(); 
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'Y');
		
		
		return orders;
		
	}
	
	

}
