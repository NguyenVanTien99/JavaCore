package as_602;

public class ShapeTest {
	
	public static void displayMaxArea(Rectangle[] rectangles) {
		
		int maxArea = rectangles[0].calculateArea();
		
		for (int i = 0; i < rectangles.length; i++) {
			if(rectangles[i].calculateArea() > maxArea) {
				maxArea = rectangles[i].calculateArea();
			}				
		}
		
		
		for (int i = 0; i < rectangles.length; i++) {
			if(rectangles[i].calculateArea() == maxArea) {
				System.out.println(rectangles[i]);
			}				
		}
		
	}
	
	
	public static void displayMinPerimeter(Rectangle[] rectangles) {
		
		int minPerimeter = rectangles[0].calculatePerimeter();
		
		for (int i = 0; i < rectangles.length; i++) {
			if(rectangles[i].calculatePerimeter() < minPerimeter) {
				minPerimeter = rectangles[i].calculatePerimeter();
			}				
		}
		
		
		for (int i = 0; i < rectangles.length; i++) {
			if(rectangles[i].calculatePerimeter() == minPerimeter) {
				System.out.println(rectangles[i]);
			}				
		}
		
	}
	
	public static void main(String[] args) {
		Rectangle[] rectangles = new Rectangle[5];
		
//		rectangles[0] = new Rectangle(2,3);
//		rectangles[1] = new Rectangle(4,5);
//		rectangles[2] = new Rectangle(6,7);
//		rectangles[3] = new Rectangle(6,7);
//		rectangles[4] = new Rectangle(3,4);
		
		
	for (int i = 0; i < rectangles.length; i++) {
		System.out.println("Enter value for rectangle " + (i+1) );
		rectangles[i] = new Rectangle();
		rectangles[i].input();
	}
	
	System.out.println("Display infor all rectangle");
	for (Rectangle rectangle : rectangles) {
		System.out.println(rectangle);
	}
	
	System.out.println("Display the information of the rectangle that has the maximum area.");
	displayMaxArea(rectangles);
	
	System.out.println("Display the information of the rectangle that has the minimum perimeter.");
	displayMinPerimeter(rectangles);
	
	
	
	}
}
