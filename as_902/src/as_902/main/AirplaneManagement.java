package as_902.main;

import java.util.Scanner;

import as_902.services.AirplaneServices;
import as_902.uitils.Constraint;

public class AirplaneManagement {
	
	public static void Menu() {
		String choice;
		Scanner scanner = new Scanner(System.in);
		
		AirplaneServices airplaneServices = new AirplaneServices();


		do {
			System.out.println("-----------Airport Management ---------------");
			System.out.println("1.Add new Fixed-Wing");
			System.out.println("2.Add new Helicopter");
			System.out.println("3.Delete Fixed-Wing");
			System.out.println("4.Delete Helicopter");
			System.out.println("5.Display all Fixed-Wing");
			System.out.println("6.Display all Helicopter");
			System.out.println("Exit");
			System.out.println("------------------------------------------------------");
			System.out.print("please Select: ");
			choice = scanner.nextLine();
			choice = choice.trim();

			switch (choice) {
			case "1":
				airplaneServices.createFixedWings(scanner);
				break;
				
			case "2":
				airplaneServices.createHelicopter(scanner);
				break;
				
			case "3":
				airplaneServices.deleteFixedwing(scanner);;
				break;
				
			case "4":
				airplaneServices.deleteHelicopter(scanner);
				break;
				
			case "5":
				airplaneServices.displayAllFixedWing();
				break;
				
			case "6":
				airplaneServices.displayAllHelicopter();
				break;

			default:
				choice = Constraint.EXIT;
				break;
			}

		} while (!choice.equalsIgnoreCase(Constraint.EXIT));
	}
}
