package as_201;

import java.util.Scanner;

public class CylinderComputation {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the cylinder radius");
		double radius = scanner.nextDouble();
		System.out.println("Enter the cylinder height");
		double height = scanner.nextDouble();		
		
		double baseArea = Math.PI * radius * radius; 
		double surfaceArea = 2 * Math.PI * radius + 2 * Math.PI * radius * radius;
		double volume = baseArea * height;
		
		System.out.println("Base area = " + baseArea);
		System.out.println("Surface area = " + surfaceArea);
		System.out.println("Volume = " + volume);
		
	
				
				
	}
}
