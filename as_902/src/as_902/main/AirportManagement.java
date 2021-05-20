package as_902.main;

import java.util.Scanner;

import as_902.services.AirplaneServices;
import as_902.services.AirportServices;
import as_902.uitils.Constraint;

public class AirportManagement {
	
	public static void Menu() {
		String choice;
		Scanner scanner = new Scanner(System.in);
		
		AirportServices airportServices = new AirportServices();
		AirplaneServices airplaneServices = new AirplaneServices();


		do {
			System.out.println("-----------Airport Management ---------------");
			System.out.println("1.Add new Airport");
			System.out.println("2.Add Fixedwing to Airport");
			System.out.println("3.Add Helicopter to Airport");
			System.out.println("4.Delete Helicopter to Airport");
			System.out.println("5.Delete Fixedwing to Airport");
			System.out.println("6.Find Airport by id");
			System.out.println("7.Display Fixedwing to Airport");
			System.out.println("8.Display Helicopter to Airport");
			System.out.println("9.Display all airports");
			System.out.println("Exit");
			System.out.println("------------------------------------------------------");
			System.out.print("please Select: ");
			choice = scanner.nextLine();
			choice = choice.trim();

			switch (choice) {
			case "1":
				airportServices.createAirports(scanner);
				break;
				
			case "2":
				airportServices.addFixedwing(scanner);
				break;
				
			case "3":
				airportServices.addHelicopter(scanner);
				break;
				
			case "4":
				airportServices.deleteHelicopter(scanner);
				break;
				
			case "5":
				System.out.println("same Delete Helicopter to Airport");
				break;
				
			case "6":
				airportServices.findAirportByID(scanner);
				break;
				
			case "7":
				airplaneServices.displayAllFixedWingHasAirport();
				break;
				
			case "8":
				airplaneServices.displayAllHelicopterHasAirport();
				break;
				
			case "9":
				airportServices.displayAllAirport();
				break;

			default:
				choice = Constraint.EXIT;
				break;
			}

		} while (!choice.equalsIgnoreCase(Constraint.EXIT));
	}
	}
	

