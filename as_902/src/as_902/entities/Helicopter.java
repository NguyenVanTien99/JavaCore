package as_902.entities;

import as_902.Exception.IdException;
import as_902.uitils.Constraint;
import as_902.uitils.Validator;

public class Helicopter extends Airplane {

	private double range;

	public Helicopter() {
	}

	public Helicopter(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight,
			String flyMethod, String idAirplaneString, double range) {
		super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight, flyMethod, idAirplaneString);
		this.range = range;
	}

	@Override
	public void setId(String id) throws IdException {
		if (Validator.isHelicopterId(id)) {
			super.setId(id);
		} else {
			throw new IdException("id format (RWXXXXX) X:1-9");
		}
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	@Override
	public String toString() {
		return "Helicopter [range=" + range + ", getId()=" + getId() + ", getModel()=" + getModel()
				+ ", getCruiseSpeed()=" + getCruiseSpeed() + ", getEmptyWeight()=" + getEmptyWeight()
				+ ", getMaxTakeoffWeight()=" + getMaxTakeoffWeight() + ", getFlyMethod()=" + getFlyMethod()
				+ ", getIdAirplaneString()=" + getIdAirport() + "]";
	}
	
	public String addInFile() {
		return getId()
				+ Constraint.COMMA + getModel() + Constraint.COMMA + getCruiseSpeed() + Constraint.COMMA
				+ getEmptyWeight() + Constraint.COMMA + getMaxTakeoffWeight() + Constraint.COMMA
				+ getFlyMethod() + Constraint.COMMA + getIdAirport() + Constraint.COMMA + range ;
	}

}
