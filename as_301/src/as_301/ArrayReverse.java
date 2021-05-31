package as_301;

public class ArrayReverse {
	
	
	/**
	 * revert element in array
	 * @param array to revert a
	 * @param length of array n
	 * 
	 * @display array has been reversed in console
	 */
	static void reverse(int a[]) {
		
		// new array
		int[] b = new int[a.length];
		
		int j = b.length;
		
		// assign the last element of b[] equal to first element of a []
		for (int i = 0; i < a.length; i++) {
			b[j - 1] = a[i];
			j -- ;
		}
		
		//display
		System.out.print("Reversed array is: \n");
		for (int k = 0; k < b.length; k++) {
			System.out.print(b[k] + " ");
		}
		
	}

	public static void main(String[] args) {
		int[] myIntArray = { 43, 32, 53, 23, 12, 34, 3, 12, 43, 32 };
		reverse(myIntArray);
	}

}
