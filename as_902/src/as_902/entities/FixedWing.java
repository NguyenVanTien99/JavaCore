package as_902.entities;

import as_902.Exception.IdException;
import as_902.Exception.PlaneTypeException;
import as_902.uitils.Constraint;
import as_902.uitils.Validator;

public class FixedWing extends Airplane {

	private String planeType;
	private double minNeededRunWay;
	
	public FixedWing() {
		
	}

	public FixedWing(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight,
			String flyMethod, String idAirplaneString, String planeType, double minNeededRunWay) {
		super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight, flyMethod, idAirplaneString);
		this.planeType = planeType;
		this.setMinNeededRunWay(minNeededRunWay);
	}
	
	


	@Override
	public void setId(String id) throws IdException {
		if (Validator.isFixedwingId(id)) {
			super.setId(id);	
		} else {
			throw new IdException("id format (FWXXXXX) X:1-9");
		}
		
		
	}

	public String getPlaneType() {
		
		return planeType;
	}


	public void setPlaneType(String planeType) throws PlaneTypeException {
		if (Validator.isFixedwingType(planeType)) {
			this.planeType = planeType;
		} else {
			throw new PlaneTypeException("CAG|LGR|PRV");
		}
	}


	public double getMinNeededRunWay() {
		return minNeededRunWay;
	}


	public void setMinNeededRunWay(double minNeededRunWay) {
		this.minNeededRunWay = minNeededRunWay;
	}

	@Override
	public String toString() {
		return "FixedWing [planeType=" + planeType + ", minNeededRunWay=" + minNeededRunWay + ", getId()=" + getId()
				+ ", getModel()=" + getModel() + ", getCruiseSpeed()=" + getCruiseSpeed() + ", getEmptyWeight()="
				+ getEmptyWeight() + ", getMaxTakeoffWeight()=" + getMaxTakeoffWeight() + ", getFlyMethod()="
				+ getFlyMethod() + ", getIdAirplaneString()=" + getIdAirport() + "]";
	}
	
	public String addInFile() {
		return getId()
				+ Constraint.COMMA + getModel() + Constraint.COMMA + getCruiseSpeed() + Constraint.COMMA
				+ getEmptyWeight() + Constraint.COMMA + getMaxTakeoffWeight() + Constraint.COMMA
				+ getFlyMethod() + Constraint.COMMA + getIdAirport() + Constraint.COMMA + planeType + Constraint.COMMA + minNeededRunWay;
	}
	
	
	
}
