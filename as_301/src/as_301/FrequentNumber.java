package as_301;

import java.util.Scanner;

public class FrequentNumber {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		// input length of array
		System.out.println("Enter the size of array");
		int n = scanner.nextInt();

		int arr[] = new int[n];
		
		//input element in array
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter the element " + (i + 1));
			arr[i] = scanner.nextInt();
		}
		
		//input element to check
		System.out.println("Enter the else you want to check");
		int check = scanner.nextInt();

		int count = 0;

		String string = "";
		
		// count occurrences of element and find index 
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == check) {
				count++;
				string += i + " ";
			}
		}

		System.out.println("Amount of frequence: " + count);
		System.out.println("Index: " + string);

	}

}
