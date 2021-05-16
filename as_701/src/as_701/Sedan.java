package as_701;

public class Sedan extends Car {
	
	private int length;

	public Sedan(int speed, double regularPrice, String color, int length) {
		super(speed, regularPrice, color);
		this.length = length;
	}

	@Override
	public double getSalePrice() {
		return super.getRegularPrice() -( super.getRegularPrice() * ( length > 20 ? 0.05: 0.1));
	}
	
	
	

}
