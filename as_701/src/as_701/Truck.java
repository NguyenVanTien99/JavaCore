package as_701;

public class Truck extends Car{
	
	private int weight;	

	public Truck(int speed, double regularPrice, String color, int weight) {
		super(speed, regularPrice, color);
		this.weight = weight;
	}


	@Override
	public double getSalePrice() {
		
		return super.getRegularPrice() - (super.getRegularPrice() * (weight > 2000 ? 0.1 : 0.2));
		
	}
	
	

}
