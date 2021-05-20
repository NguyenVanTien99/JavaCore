package as_902.entities;

import java.util.List;

import as_902.Exception.IdException;
import as_902.uitils.Constraint;
import as_902.uitils.Validator;

public class Airport implements Comparable<Airport> {
	private String id;
	private String name;
	private double runwaySize;
	private int maxFixedwingParkingPlace;
	private List<String> listOfFixedwing;
	private int maxRotatedwingParkingPlace;
	private List<String> listOfHelicopter;

	public Airport() {

	}

	public Airport(String id, String name, double runwaySize, int maxFixedwingParkingPlace,
			List<String> listOfFixedwing, int maxRotatedwingParkingPlace, List<String> listOfHelicopter) {
		super();
		this.id = id;
		this.name = name;
		this.runwaySize = runwaySize;
		this.maxFixedwingParkingPlace = maxFixedwingParkingPlace;
		this.listOfFixedwing = listOfFixedwing;
		this.maxRotatedwingParkingPlace = maxRotatedwingParkingPlace;
		this.listOfHelicopter = listOfHelicopter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws IdException {
		if (Validator.isAirportId(id)) {
			this.id = id;
		} else {
			throw new IdException("id format (APXXXXX) X:1-9");
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRunwaySize() {
		return runwaySize;
	}

	public void setRunwaySize(double runwaySize) {
		this.runwaySize = runwaySize;
	}

	public int getMaxFixedwingParkingPlace() {
		return maxFixedwingParkingPlace;
	}

	public void setMaxFixedwingParkingPlace(int maxFixedwingParkingPlace) {
		this.maxFixedwingParkingPlace = maxFixedwingParkingPlace;
	}

	public List<String> getListOfFixedwing() {
		return listOfFixedwing;
	}

	public void setListOfFixedwing(List<String> listOfFixedwing) {
		this.listOfFixedwing = listOfFixedwing;
	}

	public int getMaxRotatedwingParkingPlace() {
		return maxRotatedwingParkingPlace;
	}

	public void setMaxRotatedwingParkingPlace(int maxRotatedwingParkingPlace) {
		this.maxRotatedwingParkingPlace = maxRotatedwingParkingPlace;
	}

	public List<String> getListOfHelicopter() {
		return listOfHelicopter;
	}

	public void setListOfHelicopter(List<String> listOfHelicopter) {
		this.listOfHelicopter = listOfHelicopter;
	}

	public void showInfor() {

	}

	public String addInFile() {

		return id + Constraint.COMMA + name + Constraint.COMMA + runwaySize + Constraint.COMMA
				+ maxFixedwingParkingPlace + Constraint.COMMA + maxRotatedwingParkingPlace;
	}

	@Override
	public String toString() {
		return "Airports [id=" + id + ", name=" + name + ", runwaySize=" + runwaySize + ", maxFixedwingParkingPlace="
				+ maxFixedwingParkingPlace + ", listOfFixedwing=" + listOfFixedwing + ", maxRotatedwingParkingPlace="
				+ maxRotatedwingParkingPlace + ", listOfHelicopter=" + listOfHelicopter + "]";
	}

	@Override
	public int compareTo(Airport o) {
		return this.getId().compareTo(o.getId());
	}

}
