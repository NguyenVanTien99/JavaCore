package as_301;

import java.util.Scanner;



public class ArrayContains {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		// input length of array
		System.out.println("Enter the size of array");
		int n =  scanner.nextInt();
		
		scanner.nextLine();
		
		String arr[] = new String[n];
		
		//input element in array
		for(int i = 0; i < arr.length; i++ ) {
			System.out.println("Enter the element " + (i + 1) );
			arr[i] = scanner.nextLine();
		}
		
		//display element in array
		System.out.println("element in array: ");
		for (String e : arr) {
			System.out.println(e);
		}
		
		//input element to check
		System.out.println("Enter the element you want to check");
		String checkString = scanner.nextLine();
		
		boolean flag = false ;
		
		//return if Contained
		for (String e : arr) {
			if(checkString.equals(e)) {
				System.out.println("Contained");
				flag = true;
				break;				
			}
		}
		
		//return if not contained
		if(!flag) {
			System.out.println("No contain");
		}
	}

}
