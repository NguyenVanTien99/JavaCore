package as_602;

import java.util.Scanner;

public class Rectangle implements Shape {
	private int length;
	private int width;
	
	public Rectangle() { 
	}
	
	public Rectangle(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int calculatePerimeter() {
		return (length + width) * 2;
	}

	@Override
	public int calculateArea() {
		return length * width;
	}

	@Override
	public void setLengthWidth(int len, int width) {
		setLength(len);
		setWidth(width);
	}
	
	public void input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean check;
		
		do {
			check = false;
			System.out.println("Enter the length: ");
			
			try {
				length = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("enter the number");
				check = true;
			}
			
		} while (check);
		
		do {
			check = false;
			System.out.println("Enter the width: ");
			
			try {
				width = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("enter the number");
				check = true;
			}
			
		} while (check);
		
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + ", Perimeter=" + calculatePerimeter() + ", Area=" + calculateArea()  + "]";
	}
	
	
	
}
