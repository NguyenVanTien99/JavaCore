package as_902.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import as_902.Exception.IdException;
import as_902.Exception.IdExistEception;
import as_902.Exception.MaxTakeoffWeightException;
import as_902.Exception.ModelException;
import as_902.Exception.PlaneTypeException;
import as_902.File.FileUtil;
import as_902.entities.Airplane;
import as_902.entities.Airport;
import as_902.entities.FixedWing;
import as_902.entities.Helicopter;
import as_902.uitils.Constraint;
import as_902.uitils.ConvertObjectFromFile;
import as_902.uitils.Validator;

public class AirplaneServices {

	private static String id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight;

	public static void createNewAirplane(Airplane airplane, Scanner scanner) {

		do {
			System.out.println("Enter the Airplane id");
			try {
				id = scanner.nextLine();
				if (airplane instanceof Helicopter) {
					Validator.CheckExistHelicopterId(id);
				}

				if (airplane instanceof FixedWing) {
					Validator.CheckExistFixedwingId(id);
				}

				airplane.setId(id);
			} catch (IdException e) {
				System.out.println(e.getMessage());
				continue;
			} catch (IdExistEception e) {
				System.out.println(e.getMessage());
				continue;
			} catch (Exception e) {
				System.out.println("404 !!!");
				continue;
			}

			break;
		} while (true);

		do {
			System.out.println("Enter the model");
			model = scanner.nextLine();
			try {
				airplane.setModel(model);
			} catch (ModelException e) {
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		do {
			System.out.println("Enter the cruiseSpeed");
			cruiseSpeed = scanner.nextLine();
			try {
				Validator.isDouble(cruiseSpeed);
				airplane.setCruiseSpeed(Double.parseDouble(cruiseSpeed));
			} catch (NumberFormatException e) {
				System.out.println("value is number");
				continue;
			}
			break;
		} while (true);

		do {
			System.out.println("Enter the empty Weight");
			emptyWeight = scanner.nextLine();
			try {
				Validator.isDouble(emptyWeight);
				airplane.setEmptyWeight(Double.parseDouble(emptyWeight));
			} catch (NumberFormatException e) {
				System.out.println("value is number");
				continue;
			}
			break;
		} while (true);

		do {
			System.out.println("Enter the max Take off Weight");
			maxTakeoffWeight = scanner.nextLine();
			try {
				Validator.isDouble(maxTakeoffWeight);
				airplane.setMaxTakeoffWeight(Double.parseDouble(maxTakeoffWeight));
			} catch (NumberFormatException e) {
				System.out.println("value is number");
				continue;
			} catch (MaxTakeoffWeightException e) {
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		if (airplane instanceof FixedWing) {
			airplane.setFlyMethod("fixed wing");
		}

		if (airplane instanceof Helicopter) {
			airplane.setFlyMethod("rotated wing");
		}

	}

	public List<FixedWing> createFixedWings(Scanner scanner) {
		String loop, planeType, minNeededRunWay;

		FixedWing fixedWing;

		List<FixedWing> fixedWings = new ArrayList<>();

		do {
			fixedWing = new FixedWing();

			createNewAirplane(fixedWing, scanner);

			do {
				System.out.println("Enter the plane Type");
				planeType = scanner.nextLine();

				try {
					fixedWing.setPlaneType(planeType);
				} catch (PlaneTypeException e) {
					System.out.println(e.getMessage());
					continue;
				}
				break;
			} while (true);

			do {
				System.out.println("Enter the min Needed RunWay");
				minNeededRunWay = scanner.nextLine();
				try {
					Validator.isDouble(minNeededRunWay);
					fixedWing.setMinNeededRunWay(Double.parseDouble(minNeededRunWay));
				} catch (NumberFormatException e) {
					System.out.println("value is number");
					continue;
				}
				break;
			} while (true);

			try {
				FileUtil.writeInFile(Constraint.FILE_PATH_FIXED_WING, fixedWing.addInFile(), true);
			} catch (Exception e) {
				System.out.println(Constraint.FAIL);
				break;
			}

			fixedWings.add(fixedWing);

			System.out.println("Add Airplane " + fixedWing.getId() + " success");

			System.out.println("Do you want continue to input the Airport (Y/N)");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		return fixedWings;

	}

	public List<Helicopter> createHelicopter(Scanner scanner) {
		String loop, range;

		Helicopter helicopter;

		List<Helicopter> helicopters = new ArrayList<>();

		do {
			helicopter = new Helicopter();

			createNewAirplane(helicopter, scanner);

			do {
				System.out.println("Enter the range");
				range = scanner.nextLine();
				try {
					Validator.isDouble(range);
					helicopter.setRange(Double.parseDouble(range));
				} catch (NumberFormatException e) {
					System.out.println("value is number");
					continue;
				}
				break;
			} while (true);

			try {
				FileUtil.writeInFile(Constraint.FILE_PATH_HELICOPTER, helicopter.addInFile(), true);
			} catch (Exception e) {
				System.out.println(Constraint.FAIL);
				break;
			}

			helicopters.add(helicopter);

			System.out.println("Add Airplane " + helicopter.getId() + " success");

			System.out.println("Do you want continue to input the Airport (Y/N)");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

		return helicopters;

	}

	public void chooseFixedwing(Scanner scanner, Airport airport) {

		List<FixedWing> fixedWings = null;

		String choiceFixedwing, loop;

		List<FixedWing> newFixedWings = new ArrayList<FixedWing>();

		FixedWing newfixedWing;

		boolean check;

		int count;

		do {

			try {
				fixedWings = ConvertObjectFromFile.convertFixedWingFromFile();
			} catch (Exception e) {
				System.out.println("found");
			}

			loop = "Y";

			count = 0;

			check = true;

			newfixedWing = new FixedWing();

			System.out.println("-------------List FixedWing----------------");
			for (FixedWing fixedWing : fixedWings) {
				if (fixedWing.getIdAirport() == null) {
					System.out.println(fixedWing.addInFile());
					count++;
				}
			}
			System.out.println("------------------------------------");

			if (count == 0) {
				System.out.println("khong tim thay may bay phu hop");
				break;
			}

			System.out.println("Enter the id Fixedwing you want to add airport " + airport.getId());
			choiceFixedwing = scanner.nextLine();

			for (FixedWing fixedWing : fixedWings) {
				if (choiceFixedwing.equals(fixedWing.getId())) {
					newfixedWing = fixedWing;
					check = false;
					break;
				}
			}

			if (check) {
				System.out.println("not found");
				break;
			}

			if (newfixedWing.getMinNeededRunWay() > airport.getRunwaySize()) {
				System.out.println("Airplane has min needed runway size shorter than the airport runway size.");
				continue;
			}

			int numberofFixedwingInAirport = airport.getListOfFixedwing().size();

			if (airport.getMaxFixedwingParkingPlace() - numberofFixedwingInAirport > 0) {

				for (FixedWing fixedWing : fixedWings) {
					if (fixedWing.getId().equals(newfixedWing.getId())) {
						fixedWing.setIdAirport(airport.getId());
					}
				}

				try {
					FileUtil.deleteContentFromFile(Constraint.FILE_PATH_FIXED_WING);
				} catch (IOException e1) {
					System.out.println("Khong Xoa Duoc File");
				}

				for (FixedWing fixedWing : fixedWings) {
					try {
						FileUtil.writeInFile(Constraint.FILE_PATH_FIXED_WING, fixedWing.addInFile(), true);
					} catch (Exception e) {
						System.out.println("found");
					}
				}

				newFixedWings.add(newfixedWing);

				System.out
						.println("add plane " + newfixedWing.getId() + " to Airport" + airport.getId() + " Sucess!!!");

				System.out.println("Do you want continue to add Fixedwing to Airport (Y/N)");
				loop = scanner.nextLine();
				numberofFixedwingInAirport++;
			} else {
				System.out.println("Number of fixedwing is Max");
				loop = "N";
			}

		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

	}

	public void chooseHelicopter(Scanner scanner, Airport airport) {

		List<Helicopter> helicopters = null;

		String choiceHelicopter, loop;

		List<Helicopter> newHelicopters = new ArrayList<>();

		Helicopter newHelicopter;

		boolean check;

		int count;

		do {

			try {
				helicopters = ConvertObjectFromFile.convertHelicopterFromFile();
			} catch (Exception e) {
				System.out.println("found");
			}

			loop = "Y";

			count = 0;

			check = true;

			newHelicopter = new Helicopter();

			System.out.println("-------------List FixedWing----------------");
			for (Helicopter helicopter : helicopters) {
				if (helicopter.getIdAirport() == null) {
					System.out.println(helicopter.addInFile());
					count++;
				}
			}
			System.out.println("------------------------------------");

			if (count == 0) {
				System.out.println("khong tim thay may bay phu hop");
				break;
			}

			System.out.println("Enter the id Helicopter you want to add airport " + airport.getId());
			choiceHelicopter = scanner.nextLine();

			for (Helicopter helicopter : helicopters) {
				if (choiceHelicopter.equals(helicopter.getId())) {
					newHelicopter = helicopter;
					check = false;
					break;
				}
			}

			if (check) {
				System.out.println("not found");
				break;
			}

			int numberofFixedwingInAirport = airport.getListOfHelicopter().size();

			if (airport.getMaxRotatedwingParkingPlace() - numberofFixedwingInAirport > 0) {

				for (Helicopter helicopter : helicopters) {
					if (helicopter.getId().equals(newHelicopter.getId())) {
						helicopter.setIdAirport(airport.getId());
					}
				}

				try {
					FileUtil.deleteContentFromFile(Constraint.FILE_PATH_HELICOPTER);
				} catch (IOException e1) {
					System.out.println("Khong Xoa Duoc File");
				}

				for (Helicopter helicopter : helicopters) {
					try {
						FileUtil.writeInFile(Constraint.FILE_PATH_HELICOPTER, helicopter.addInFile(), true);
					} catch (Exception e) {
						System.out.println("found");
					}
				}

				newHelicopters.add(newHelicopter);

				System.out
						.println("add plane " + newHelicopter.getId() + " to Airport" + airport.getId() + " Sucess!!!");

				System.out.println("Do you want continue to add herlicopter to Airport (Y/N)");
				loop = scanner.nextLine();
				numberofFixedwingInAirport++;
			} else {
				System.out.println("Number of fixedwing is Max");
				loop = "N";
			}

		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

	}

	public void deleteHelicopterFromAirport(Scanner scanner, Airport airport) {

		List<Helicopter> helicopters = null;

		String choiceHelicopter, loop;

		List<Helicopter> newHelicopters = new ArrayList<>();

		Helicopter newHelicopter;

		boolean check;

		int count;

		do {

			try {
				helicopters = ConvertObjectFromFile.convertHelicopterFromFile();
			} catch (Exception e) {
				System.out.println("found");
			}

			loop = "Y";

			count = 0;

			check = true;

			newHelicopter = new Helicopter();

			System.out.println("-------------List FixedWing----------------");
			for (Helicopter helicopter : helicopters) {
				if (helicopter.getIdAirport() != null && helicopter.getIdAirport().equals(airport.getId())) {
					System.out.println(helicopter.addInFile());
					count++;
				}
			}
			System.out.println("------------------------------------");

			if (count == 0) {
				System.out.println("khong tim thay may bay phu hop");
				break;
			}

			System.out.println("Enter the id Helicopter you want to remove airport " + airport.getId());
			choiceHelicopter = scanner.nextLine();

			for (Helicopter helicopter : helicopters) {
				if (choiceHelicopter.equals(helicopter.getId())) {
					newHelicopter = helicopter;
					check = false;
					break;
				}
			}

			if (check) {
				System.out.println("not found");
				break;
			}

			for (Helicopter helicopter : helicopters) {
				if (helicopter.getId().equals(newHelicopter.getId())) {
					helicopter.setIdAirport(null);
				}
			}

			try {
				FileUtil.deleteContentFromFile(Constraint.FILE_PATH_HELICOPTER);
			} catch (IOException e1) {
				System.out.println("Khong Xoa Duoc File");
			}

			for (Helicopter helicopter : helicopters) {
				try {
					FileUtil.writeInFile(Constraint.FILE_PATH_HELICOPTER, helicopter.addInFile(), true);
				} catch (Exception e) {
					System.out.println("found");
				}
			}

			newHelicopters.add(newHelicopter);

			System.out.println("delete " + newHelicopter.getId() + " to Airport" + airport.getId() + " Sucess!!!");

			System.out.println("Do you want continue to delete helicopter to Airport (Y/N)");
			loop = scanner.nextLine();

		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

	}

	public void deleteHelicopter(Scanner scanner) {

		List<Helicopter> helicopters = null;

		String choiceHelicopter, loop;

		Helicopter tempHelicopter;

		boolean check;

		do {

			try {
				helicopters = ConvertObjectFromFile.convertHelicopterFromFile();
			} catch (Exception e) {
				System.out.println("found");
			}

			tempHelicopter = new Helicopter();

			loop = "Y";

			check = true;

			System.out.println("-------------List FixedWing----------------");
			for (Helicopter helicopter : helicopters) {
				System.out.println(helicopter.addInFile());
			}
			System.out.println("------------------------------------");

			System.out.println("Enter the id Helicopter you want to remove ");
			choiceHelicopter = scanner.nextLine();

			for (int i = 0; i < helicopters.size(); i++) {
				if (choiceHelicopter.equals(helicopters.get(i).getId())) {
					tempHelicopter = helicopters.get(i);
					helicopters.remove(i);
					check = false;
					break;
				}
			}

			if (check) {
				System.out.println("not found");
				break;
			}

			try {
				FileUtil.deleteContentFromFile(Constraint.FILE_PATH_HELICOPTER);
			} catch (IOException e1) {
				System.out.println("Khong Xoa Duoc File");
			}

			for (Helicopter helicopter : helicopters) {
				try {
					FileUtil.writeInFile(Constraint.FILE_PATH_HELICOPTER, helicopter.addInFile(), true);
				} catch (Exception e) {
					System.out.println("found");
				}
			}

			System.out.println("remove " + tempHelicopter.getId() + " Sucess!!!");

			System.out.println("Do you want continue to delete helicopter to Airport (Y/N)");
			loop = scanner.nextLine();

		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

	}

	public void deleteFixedwing(Scanner scanner) {

		List<FixedWing> fixedWings = null;

		String choiceFixedWing, loop;

		FixedWing tempFixedWing;

		boolean check;

		do {

			try {
				fixedWings = ConvertObjectFromFile.convertFixedWingFromFile();
			} catch (Exception e) {
				System.out.println("found");
			}

			tempFixedWing = new FixedWing();

			loop = "Y";

			check = true;

			System.out.println("-------------List FixedWing----------------");
			for (FixedWing helicopter : fixedWings) {
				System.out.println(helicopter.addInFile());
			}
			System.out.println("------------------------------------");

			System.out.println("Enter the id Helicopter you want to remove ");
			choiceFixedWing = scanner.nextLine();

			for (int i = 0; i < fixedWings.size(); i++) {
				if (choiceFixedWing.equals(fixedWings.get(i).getId())) {
					tempFixedWing = fixedWings.get(i);
					fixedWings.remove(i);
					check = false;
					break;
				}
			}

			if (check) {
				System.out.println("not found");
				break;
			}

			try {
				FileUtil.deleteContentFromFile(Constraint.FILE_PATH_FIXED_WING);
			} catch (IOException e1) {
				System.out.println("Khong Xoa Duoc File");
			}

			for (FixedWing helicopter : fixedWings) {
				try {
					FileUtil.writeInFile(Constraint.FILE_PATH_FIXED_WING, helicopter.addInFile(), true);
				} catch (Exception e) {
					System.out.println("found");
				}
			}

			System.out.println("remove " + tempFixedWing.getId() + " Sucess!!!");

			System.out.println("Do you want continue to delete Fixedwing to Airport (Y/N)");
			loop = scanner.nextLine();

		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

	}

	public void updateFixedwing(Scanner scanner) {

		List<FixedWing> fixedWings = null;

		String choiceFixedWing, loop, planeType, minNeededRunWay;

		FixedWing tempFixedWing;

		boolean check;

		do {

			try {
				fixedWings = ConvertObjectFromFile.convertFixedWingFromFile();
			} catch (Exception e) {
				System.out.println("found");
			}

			tempFixedWing = new FixedWing();

			loop = "Y";

			check = true;

			System.out.println("-------------List FixedWing----------------");
			for (FixedWing helicopter : fixedWings) {
				System.out.println(helicopter.addInFile());
			}
			System.out.println("------------------------------------");

			System.out.println("Enter the id Helicopter you want to update ");
			choiceFixedWing = scanner.nextLine();

			for (int i = 0; i < fixedWings.size(); i++) {
				if (choiceFixedWing.equals(fixedWings.get(i).getId())) {
					tempFixedWing = fixedWings.get(i);
					check = false;
					break;
				}
			}

			if (check) {
				System.out.println("not found");
				break;
			}

			do {
				System.out.println("Enter the plane Type");
				planeType = scanner.nextLine();

				try {
					tempFixedWing.setPlaneType(planeType);
				} catch (PlaneTypeException e) {
					System.out.println(e.getMessage());
					continue;
				}
				break;
			} while (true);

			do {
				System.out.println("Enter the min Needed RunWay");
				minNeededRunWay = scanner.nextLine();
				try {
					Validator.isDouble(minNeededRunWay);
					tempFixedWing.setMinNeededRunWay(Double.parseDouble(minNeededRunWay));
				} catch (NumberFormatException e) {
					System.out.println("value is number");
					continue;
				}
				break;
			} while (true);

			for (FixedWing fixedWing : fixedWings) {
				if (fixedWing.getId().equals(tempFixedWing.getId())) {
					fixedWing = tempFixedWing;
				}
			}

			try {
				FileUtil.deleteContentFromFile(Constraint.FILE_PATH_FIXED_WING);
			} catch (IOException e1) {
				System.out.println("Khong Xoa Duoc File");
			}

			for (FixedWing helicopter : fixedWings) {
				try {
					FileUtil.writeInFile(Constraint.FILE_PATH_FIXED_WING, helicopter.addInFile(), true);
				} catch (Exception e) {
					System.out.println("found");
				}
			}

			System.out.println("update " + tempFixedWing.getId() + " Sucess!!!");

			System.out.println("Do you want continue to update Fixedwing to Airport (Y/N)");
			loop = scanner.nextLine();

		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

	}

	public void displayAllFixedWingHasAirport() {
		List<FixedWing> fixedWings = null;

		try {
			fixedWings = ConvertObjectFromFile.convertFixedWingFromFile();
		} catch (Exception e) {
			System.out.println("found");
		}

		List<Airport> airports = null;

		try {
			airports = ConvertObjectFromFile.convertAirportsFromFile();

		} catch (Exception e) {
			System.out.println("404 !!!");
		}

		for (FixedWing fixedWing : fixedWings) {
			for (Airport airport : airports) {

				if (fixedWing.getIdAirport() != null && fixedWing.getIdAirport().equals(airport.getId())) {
					System.out.println(fixedWing.addInFile() + " of Airport " + airport.getName());
				}
			}
		}

	}

	public void displayAllHelicopterHasAirport() {
		List<Helicopter> fixedWings = null;

		try {
			fixedWings = ConvertObjectFromFile.convertHelicopterFromFile();
		} catch (Exception e) {
			System.out.println("found");
		}

		List<Airport> airports = null;

		try {
			airports = ConvertObjectFromFile.convertAirportsFromFile();

		} catch (Exception e) {
			System.out.println("404 !!!");
		}

		for (Helicopter fixedWing : fixedWings) {
			for (Airport airport : airports) {
				if (fixedWing.getIdAirport() != null && fixedWing.getIdAirport().equals(airport.getId())) {
					System.out.println(fixedWing.addInFile() + " of Airport " + airport.getName());
				}
			}
		}

	}

	public void displayAllFixedWing() {
		List<FixedWing> fixedWings = null;

		try {
			fixedWings = ConvertObjectFromFile.convertFixedWingFromFile();
		} catch (Exception e) {
			System.out.println("found");
		}

		for (FixedWing fixedWing : fixedWings) {

			System.out.println(fixedWing.addInFile());
		}
	}

	public void displayAllHelicopter() {
		List<Helicopter> fixedWings = null;

		try {
			fixedWings = ConvertObjectFromFile.convertHelicopterFromFile();
		} catch (Exception e) {
			System.out.println("found");
		}

		for (Helicopter fixedWing : fixedWings) {
			System.out.println(fixedWing.addInFile());
		}

	}

}
