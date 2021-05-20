package as_902.uitils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import as_902.Exception.IdException;
import as_902.Exception.MaxTakeoffWeightException;
import as_902.Exception.ModelException;
import as_902.Exception.PlaneTypeException;
import as_902.File.FileUtil;
import as_902.entities.Airport;
import as_902.entities.FixedWing;
import as_902.entities.Helicopter;


public class ConvertObjectFromFile {
	
	public static List<Airport> convertAirportsFromFile() throws IOException, IdException, NumberFormatException, ModelException, MaxTakeoffWeightException, PlaneTypeException {
		List<Airport> airportList = new ArrayList<Airport>();
		List<FixedWing> fixedWingsList = convertFixedWingFromFile();
		List<Helicopter> helicoptersList = convertHelicopterFromFile();
		
		List<String> strings = FileUtil.readFromFile(Constraint.FILE_PATH_AIRPORTS);
		Airport airports;
		
		
		for (String string : strings) {
			
			List<String> ListOfFixedwing = new ArrayList<String>();
			List<String> ListOfHelicopter = new ArrayList<String>();
			
			String[] stringSplit = string.split(",");
			airports = new Airport();			
	
			airports.setId(stringSplit[0]);		
			airports.setName(stringSplit[1]);
			airports.setRunwaySize(Double.parseDouble(stringSplit[2]));
			airports.setMaxFixedwingParkingPlace(Integer.parseInt(stringSplit[3]));
			airports.setMaxRotatedwingParkingPlace(Integer.parseInt(stringSplit[4]));
			
			for (FixedWing fixedWing : fixedWingsList) {
				if (fixedWing.getIdAirport() != null && fixedWing.getIdAirport().equals(stringSplit[0])) {
					ListOfFixedwing.add(fixedWing.getId());
				}
			}
			 
			for (Helicopter helicopter : helicoptersList) {
				if (helicopter.getIdAirport() != null && helicopter.getIdAirport().equals(stringSplit[0])) {
					ListOfHelicopter.add(helicopter.getId());
				}
			}
			
			airports.setListOfFixedwing(ListOfFixedwing);
			airports.setListOfHelicopter(ListOfHelicopter);
			
			
			airportList.add(airports);
		}
		
		return airportList;
	}
	
	
	public static List<FixedWing> convertFixedWingFromFile() throws IOException, IdException, ModelException, NumberFormatException, MaxTakeoffWeightException, PlaneTypeException {
		List<FixedWing> fixedWingsList = new ArrayList<>();
		
		List<String> strings = FileUtil.readFromFile(Constraint.FILE_PATH_FIXED_WING);
		
		for (String string : strings) {
			String[] stringSplit = string.split(",");
			FixedWing fixedWing = new FixedWing();			
	
			fixedWing.setId(stringSplit[0]);		
			fixedWing.setModel(stringSplit[1]);
			fixedWing.setCruiseSpeed(Double.parseDouble(stringSplit[2]));
			fixedWing.setEmptyWeight(Double.parseDouble(stringSplit[3]));
			fixedWing.setMaxTakeoffWeight(Double.parseDouble(stringSplit[4]));
			fixedWing.setFlyMethod(stringSplit[5]);
			
			if(!stringSplit[6].equals("null")) {
				fixedWing.setIdAirport(stringSplit[6]);
			}
				
			fixedWing.setPlaneType(stringSplit[7]);
		
			fixedWing.setMinNeededRunWay(Double.parseDouble(stringSplit[8]));
			
			fixedWingsList.add(fixedWing);
		}
		return fixedWingsList;
	}
	
	public static List<Helicopter> convertHelicopterFromFile() throws IOException, IdException, ModelException, NumberFormatException, MaxTakeoffWeightException {
		 List<Helicopter> helicoptersList = new ArrayList<>();
		
		List<String> strings = FileUtil.readFromFile(Constraint.FILE_PATH_HELICOPTER);
		
		for (String string : strings) {
			String[] stringSplit = string.split(",");
			Helicopter helicopter = new Helicopter();			
	
			helicopter.setId(stringSplit[0]);		
			helicopter.setModel(stringSplit[1]);
			helicopter.setCruiseSpeed(Double.parseDouble(stringSplit[2]));
			helicopter.setEmptyWeight(Double.parseDouble(stringSplit[3]));
			helicopter.setMaxTakeoffWeight(Double.parseDouble(stringSplit[4]));
			helicopter.setFlyMethod(stringSplit[5]);
			
			if(!stringSplit[6].equals("null")) {
				helicopter.setIdAirport(stringSplit[6]);
			}
				
			helicopter.setRange(Double.parseDouble(stringSplit[7]));
			
			helicoptersList.add(helicopter);
		}
		return helicoptersList;
	}
		
}
