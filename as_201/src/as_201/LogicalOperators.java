package as_201;

import java.util.Scanner;

public class LogicalOperators {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter the number one");
			int number1 = scanner.nextInt();
			System.out.println("Enter the number two");
			int number2 = scanner.nextInt();
			System.out.println("Enter the number three");
			int number3 = scanner.nextInt();
			System.out.println("Enter the number four");
			int number4 = scanner.nextInt();
			
			if(number1 == number2 && number2 == number3 && number3 == number4) {
				System.out.println("Number is equal");
			}else {
				System.out.println("Number is not equal");
			}
		} while (true);
		
		
	}

}
