package as_902.uitils;


import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import as_902.Exception.IdException;
import as_902.Exception.IdExistEception;
import as_902.Exception.MaxTakeoffWeightException;
import as_902.Exception.ModelException;
import as_902.Exception.PlaneTypeException;
import as_902.entities.Airport;
import as_902.entities.FixedWing;
import as_902.entities.Helicopter;



public class Validator {

	private static final String VALID_AIRPORT_ID_REGEX = "AP\\d{5}";
	private static final String VALID_FIXEDWING_ID_REGEX = "FW\\d{5}";
	private static final String VALID_HELICOPTER_ID_REGEX = "RW\\d{5}";
	private static final String VALID_FIXEDWING_TYPE_REGEX = "^(CAG|LGR|PRV)$";

	private static Pattern pattern;
	private static Matcher matcher;

	public static boolean isAirportId(String id) {
		pattern = Pattern.compile(VALID_AIRPORT_ID_REGEX);
		matcher = pattern.matcher(id);
		return matcher.matches();
	}

	public static boolean isFixedwingId(String id) {
		pattern = Pattern.compile(VALID_FIXEDWING_ID_REGEX);
		matcher = pattern.matcher(id);
		return matcher.matches();
	}

	public static boolean isHelicopterId(String id) {
		pattern = Pattern.compile(VALID_HELICOPTER_ID_REGEX);
		matcher = pattern.matcher(id);
		return matcher.matches();
	}

	public static boolean isFixedwingType(String type) {
		pattern = Pattern.compile(VALID_FIXEDWING_TYPE_REGEX);
		matcher = pattern.matcher(type);
		return matcher.matches();
	}

	public static boolean isModelSize(String size) {
		if (size.length() > 40) {
			return false;
		}
		return true;
	}

	public static double isDouble(String number) {
		double d = 0d;
		try {
			d = Double.parseDouble(number);
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
		return d;
	}

	public static int isInt(String number) {
		int i = 0;
		try {
			i = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
		return i;
	}
	
	public static void CheckExistAirportsId (String id) throws IOException, IdException, IdExistEception, NumberFormatException, ModelException, MaxTakeoffWeightException, PlaneTypeException {
		List<Airport> airports = ConvertObjectFromFile.convertAirportsFromFile();
		for (Airport airport : airports) {
			if (id.equals(airport.getId())) {
				throw new IdExistEception("id da ton tai");
			}
		}
	}
	
	public static void CheckExistFixedwingId (String id) throws IOException, IdException, IdExistEception, NumberFormatException, ModelException, MaxTakeoffWeightException, PlaneTypeException {
		List<FixedWing> fixedWings = ConvertObjectFromFile.convertFixedWingFromFile();
		for (FixedWing fixedWing : fixedWings) {
			if (id.equals(fixedWing.getId())) {
				throw new IdExistEception("id da ton tai");
			}
		}
	}
	
	public static void CheckExistHelicopterId (String id) throws IOException, IdException, IdExistEception, NumberFormatException, ModelException, MaxTakeoffWeightException {
		List<Helicopter> helicopters = ConvertObjectFromFile.convertHelicopterFromFile();
		for (Helicopter helicopter : helicopters) {
			if (id.equals(helicopter.getId())) {
				throw new IdExistEception("id da ton tai");
			}
		}
	}
	

	
}
