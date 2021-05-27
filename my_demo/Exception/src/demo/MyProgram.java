package demo;

import javax.management.RuntimeErrorException;

public class MyProgram {
//	void now() {
//		throw new Exception();
//	}
	
	private static void throwit() {
		throw new RuntimeException();
	}
	
	public static int main1() {
		try {
			System.out.println("hello word");
			throwit();
			System.out.println("Done with try block");
		}catch (RuntimeException e) {
			System.out.println("hello");
			return 1;
		} finally {
			System.out.println("Finally excuting");
		}
		return 0;
	}
	
	public static void main(String[] args) {
		try {
			int y = 5/0;
		} catch (Exception e) {
			System.out.println("Exception");
		} 
	}
}
