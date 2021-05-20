package as_902.main;


import java.util.Scanner;

import as_902.uitils.Constraint;

public class Management {	
	public static void main(String[] args) {
		String choice;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);


		do {
			System.out.println("----------- Management ---------------");
			System.out.println("1.Manage Airport");
			System.out.println("2.Manage Airplane");
			System.out.println("Exit");
			System.out.println("------------------------------------------------------");
			System.out.print("please Select: ");
			choice = scanner.nextLine();
			choice = choice.trim();

			switch (choice) {
			case "1":
				AirportManagement.Menu();
				break;

			case "2":
				AirplaneManagement.Menu();
				
				break;

			default:
				choice = Constraint.EXIT;
				break;
			}

		} while (!choice.equalsIgnoreCase(Constraint.EXIT));
	}
	
	}


