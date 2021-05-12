package as_101;

public class Operator {
	
	public static void ArithmeticExercise1() {
		System.out.println(-5 + 8 * 6);
		System.out.println((55+9) % 9);
		System.out.println(20 + -3*5 / 8);
		System.out.println(5 + 15 / 3 * 2 - 8 % 3);
		System.out.println("--------------------------------");
	}
	
	public static void ArithmeticExercise2(int a, int b) {
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		System.out.println("--------------------------------");
		
	}
	
	public static void JavaExercise() {
		System.out.println("J    a   v     v  a");
		System.out.println(" J   a a   v   v  a a");
		System.out.println("J  J  aaaaa   V V  aaaaa");
		System.out.println("JJ  a     a   V  a     a");		
		System.out.println("--------------------------------");
	}
	
	public static void ArithmeticExercise3() {
		System.out.println(((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5)));	
		System.out.println("--------------------------------");
	}
	
	public static void CircleExercise(double r) {
		System.out.println("Perimeter is = " + 2*Math.PI*r);	
		System.out.println("Area is = " + Math.PI*r*r);
		System.out.println("--------------------------------");
	}
	
	public static void RectangleExercise(double a, double b) {
		System.out.println("Area is " + a + "*" + b + "=" + a*b);
		System.out.println("Perimeter is 2 * (" + a + "+" + b + ") =" + 2*(a+b));
		System.out.println("--------------------------------");
	}
	
	public static void LogicalExercise(double a, double b) {
		System.out.println(a != b);
		System.out.println(a < b);
		System.out.println(a <= b);
	}
	
	
	
	public static void main(String[] args) {
		Operator.ArithmeticExercise1();
		
		Operator.ArithmeticExercise2(125, 24);
		
		Operator.JavaExercise();
		
		Operator.ArithmeticExercise3();
		
		Operator.CircleExercise(7.5);
		
		Operator.RectangleExercise(5.5, 8.5);
		
		Operator.LogicalExercise(25, 39);
		
		
		
	}

}
