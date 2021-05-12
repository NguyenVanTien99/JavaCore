package as_301;

import java.util.Iterator;

public class ArrayReverse {
	static void reverse(int a[], int n) {
		int[] b = new int[n];
		int j = n;
		for (int i = 0; i < n; i++) {
			b[j - 1] = a[i];
			j -- ;
		}

		System.out.println("Reversed array is: \n");
		for (int k = 0; k < n; k++) {
			System.out.println(b[k]);
		}
	}

	public static void main(String[] args) {
		int[] myIntArray = { 43, 32, 53, 23, 12, 34, 3, 12, 43, 32 };
		reverse(myIntArray, myIntArray.length);
	}

}