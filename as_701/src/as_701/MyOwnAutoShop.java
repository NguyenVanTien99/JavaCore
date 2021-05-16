package as_701;

import java.util.ArrayList;

public class MyOwnAutoShop {
	public static void main(String[] args) {
		Sedan sedan1 = new Sedan(150, 300, "Red", 10);
		Sedan sedan2 = new Sedan(250, 400, "Yellow", 25);
		
		Ford ford1 = new Ford(100, 500, "green", 1999, 50);
		Ford ford2 = new Ford(200, 600, "pink", 2000, 100);
		
		Truck truck1 = new Truck(500, 650, "Violet", 9000);
		Truck truck2 = new Truck(500, 650, "Violet", 9000);
		
		
		ArrayList<Car> cars = new ArrayList<Car>();
		
		cars.add(sedan1);
		cars.add(sedan2);
		cars.add(ford1);
		cars.add(ford2);
		cars.add(truck1);
		cars.add(truck2);
		
		for (Car car : cars) {
			System.out.println("Sale Price: " + car.getSalePrice());
		}
		
		
	}

}
