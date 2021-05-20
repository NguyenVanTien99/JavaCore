package as_902.entities;

import as_902.Exception.IdException;
import as_902.Exception.MaxTakeoffWeightException;
import as_902.Exception.ModelException;

public class Airplane {
	private String id;
	private String model;
	private double cruiseSpeed ;
	private double emptyWeight;
	private double maxTakeoffWeight;
	private String flyMethod;
	private String idAirport;
	
	public Airplane() {
		
	}
	
	public Airplane(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight,
			String flyMethod, String idAirplaneString) {
		super();
		this.id = id;
		this.model = model;
		this.cruiseSpeed = cruiseSpeed;
		this.emptyWeight = emptyWeight;
		this.maxTakeoffWeight = maxTakeoffWeight;
		this.flyMethod = flyMethod;
		this.idAirport = idAirplaneString;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws IdException {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) throws ModelException {
		if(model.length() < 40) {
			this.model = model;
		}else {
			throw new ModelException("Model size is maximum 40 character");
		}
	}

	public double getCruiseSpeed() {
		return cruiseSpeed;
	}

	public void setCruiseSpeed(double cruiseSpeed) {
		this.cruiseSpeed = cruiseSpeed;
	}


	public double getEmptyWeight() {
		return emptyWeight;
	}

	public void setEmptyWeight(double emptyWeight) {
		this.emptyWeight = emptyWeight;
	}

	public double getMaxTakeoffWeight() {
		return maxTakeoffWeight;
	}

	public void setMaxTakeoffWeight(double maxTakeoffWeight) throws MaxTakeoffWeightException  {
		if (maxTakeoffWeight > emptyWeight*1.5) {
			throw new MaxTakeoffWeightException("The max takeoff weight of helicopter does not excess 1.5 times of its empty weight");
		}
		
		this.maxTakeoffWeight = maxTakeoffWeight;
	}

	public String getFlyMethod() {
		return flyMethod;
	}

	public void setFlyMethod(String flyMethod) {
		this.flyMethod = flyMethod;
	}

	public String getIdAirport() {
		return idAirport;
	}

	public void setIdAirport(String idAirplaneString) {
		this.idAirport = idAirplaneString;
	}

}
