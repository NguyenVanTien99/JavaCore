package as_902.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import as_902.Exception.IdException;
import as_902.Exception.IdExistEception;
import as_902.File.FileUtil;
import as_902.entities.Airport;
import as_902.uitils.Constraint;
import as_902.uitils.ConvertObjectFromFile;
import as_902.uitils.Validator;

public class AirportServices {

	AirplaneServices airplaneServices = new AirplaneServices();

	public List<Airport> createAirports(Scanner scanner) {
		String loop, id, name, runwaySize, maxFixedwingParkingPlace, maxRotatedwingParkingPlace;

		Airport airports;

		List<Airport> airportsList = new ArrayList<Airport>();

		do {
			airports = new Airport();

			// Set id
			do {
				System.out.println("Enter the Airports id");

				try {
					id = scanner.nextLine();
					Validator.CheckExistAirportsId(id);
					airports.setId(id);
				} catch (IdException e) {
					System.out.println(e.getMessage());
					continue;
				} catch (IdExistEception e) {
					System.out.println(e.getMessage());
					continue;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
				break;
			} while (true);

			// set name
			System.out.println("Enter the Airports name");
			name = scanner.nextLine();
			airports.setName(name);

			// set runway size

			do {
				System.out.println("Enter the runway size");
				runwaySize = scanner.nextLine();
				try {
					Validator.isDouble(runwaySize);
					airports.setRunwaySize(Double.parseDouble(runwaySize));
				} catch (NumberFormatException e) {
					System.out.println("value is number");
					continue;
				}
				break;
			} while (true);

			// set max Fixed wing Parking Place
			do {
				System.out.println("Enter the max Fixed wing Parking Place");
				maxFixedwingParkingPlace = scanner.nextLine();
				try {
					Validator.isDouble(maxFixedwingParkingPlace);
					airports.setMaxFixedwingParkingPlace(Integer.parseInt(maxFixedwingParkingPlace));
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					continue;
				}
				break;
			} while (true);

			// max Rotated wing Parking Place
			do {
				System.out.println("Enter the max Rotated wing Parking Place");
				maxRotatedwingParkingPlace = scanner.nextLine();
				try {
					Validator.isDouble(maxRotatedwingParkingPlace);
					airports.setMaxRotatedwingParkingPlace(Integer.parseInt(maxRotatedwingParkingPlace));
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
					continue;
				}
				break;
			} while (true);

			try {
				FileUtil.writeInFile(Constraint.FILE_PATH_AIRPORTS, airports.addInFile(), true);
			} catch (Exception e) {
				System.out.println(Constraint.FAIL);
				break;
			}

			airportsList.add(airports);

			System.out.println("Add airport " + airports.getId() + " success");

			System.out.println("Do you want continue to input the Airport (Y/N)");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

		return airportsList;

	}

	public void addFixedwing(Scanner scanner) {

		String choiceAirport, loop = "Y";

		Airport newAirport;

		boolean check;

		do {

			List<Airport> airports = null;

			try {
				airports = ConvertObjectFromFile.convertAirportsFromFile();

			} catch (Exception e) {
				System.out.println("404 !!!");
			}

			check = true;

			if (airports.size() == 0) {
				System.out.println("Not Found");
				continue;
			}

			System.out.println("--------------List Airport--------------");
			for (Airport airport : airports) {
				System.out.println(airport.addInFile());
			}
			System.out.println("------------------------------------------");

			newAirport = new Airport();
			System.out.println("Enter the id Airport");
			choiceAirport = scanner.nextLine();

			for (Airport airport : airports) {
				if (choiceAirport.equals(airport.getId())) {
					newAirport = airport;
					check = false;
					break;
				}
			}

			if (check) {
				System.out.println("not found");
				continue;
			}

			if (newAirport.getMaxFixedwingParkingPlace() - newAirport.getListOfFixedwing().size() > 0) {
				airplaneServices.chooseFixedwing(scanner, newAirport);
				System.out.println("Do you want continue choose Airport (Y/N)");
				loop = scanner.nextLine();
			} else {
				System.out.println("Max fixedwing");
				loop = "N";
			}

		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

	}

	public void addHelicopter(Scanner scanner) {

		String choiceAirport, loop = "Y";

		Airport newAirport;

		boolean check;

		do {

			List<Airport> airports = null;

			try {
				airports = ConvertObjectFromFile.convertAirportsFromFile();

			} catch (Exception e) {
				System.out.println("404 !!!");
			}

			check = true;

			if (airports.size() == 0) {
				System.out.println("Not Found");
				continue;
			}

			System.out.println("--------------List Airport--------------");
			for (Airport airport : airports) {
				System.out.println(airport.addInFile());
			}
			System.out.println("------------------------------------------");

			newAirport = new Airport();
			System.out.println("Enter the id Airport");
			choiceAirport = scanner.nextLine();

			for (Airport airport : airports) {
				if (choiceAirport.equals(airport.getId())) {
					newAirport = airport;
					check = false;
					break;
				}
			}

			if (check) {
				System.out.println("not found");
				continue;
			}

			if (newAirport.getMaxRotatedwingParkingPlace() - newAirport.getListOfHelicopter().size() > 0) {
				airplaneServices.chooseHelicopter(scanner, newAirport);
				System.out.println("Do you want continue choose Airport (Y/N)");
				loop = scanner.nextLine();
			} else {
				System.out.println("Max Helicopter");
				loop = "N";
			}

		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

	}

	public void deleteHelicopter(Scanner scanner) {

		String choiceAirport, loop = "Y";

		Airport newAirport;

		boolean check;

		do {

			List<Airport> airports = null;

			try {
				airports = ConvertObjectFromFile.convertAirportsFromFile();

			} catch (Exception e) {
				System.out.println("404 !!!");
			}

			check = true;

			if (airports.size() == 0) {
				System.out.println("Not Found");
				continue;
			}

			System.out.println("--------------List Airport--------------");
			for (Airport airport : airports) {
				System.out.println(airport.addInFile());
			}
			System.out.println("------------------------------------------");

			newAirport = new Airport();
			System.out.println("Enter the id Airport");
			choiceAirport = scanner.nextLine();

			for (Airport airport : airports) {
				if (choiceAirport.equals(airport.getId())) {
					newAirport = airport;
					check = false;
					break;
				}
			}

			if (check) {
				System.out.println("not found");
				continue;
			}

			airplaneServices.deleteHelicopterFromAirport(scanner, newAirport);

			System.out.println("Do you want continue choose Airport (Y/N)");
			loop = scanner.nextLine();

		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

	}
	
	public void displayAllAirport() {
		List<Airport> airports = null;

		try {
			airports = ConvertObjectFromFile.convertAirportsFromFile();

		} catch (Exception e) {
			System.out.println("404 !!!");
		}
		
		Collections.sort(airports);
		
		for (Airport airport : airports) {
			System.out.println(airport.addInFile());
		}
	}
	
	public void findAirportByID(Scanner scanner) {
		List<Airport> airports = null;
		
		boolean check = true;

		try {
			airports = ConvertObjectFromFile.convertAirportsFromFile();

		} catch (Exception e) {
			System.out.println("404 !!!");
		}
		System.out.println("Enter the ID Airport you want to find");
		
		String choose = scanner.nextLine();
		
		for (Airport airport : airports) {
			if (airport.getId().equals(choose)) {
				System.out.println(airport);
				check = false;
				break;
			}		
		}
		
		if (check) {
			System.out.println("Not found Airport with id: " + choose);
		}
		
		
		
	}

	public static void main(String[] args) {
		AirportServices airportServices = new AirportServices();

		airportServices.findAirportByID(new Scanner(System.in));
	}

}
