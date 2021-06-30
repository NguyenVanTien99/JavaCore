package main;


class X {
	
	int a = 1;
	
	void m1(X x) {
		System.out.println("X");
	}
}

class Y extends X {
	int b = 2;
	int a = 3;
}

class Z extends Y {
	void m1(Z z) {
		System.out.println("Z");
	}	
}

public class Test  {
	
	public static void main(String[] args) {
		String s1 = new String("ABCD12349");
		
		String s2 = "ABCD12349";
		
		String s3 = s1.substring(4,8);
		
		String s4 = s2.substring(4,8);
		
		System.out.println(s3 + " " + s4);
		
		System.out.println((s3+s4).equals(s4+s3));
		
	}
	

}
