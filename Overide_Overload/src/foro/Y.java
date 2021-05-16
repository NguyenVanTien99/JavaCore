package foro;


public class Y {
	static int s;
	
	int u;

	{
		s = 6;
	}
	
	{
		s = 7;
	}
	
	static {
		s = 8;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Y.s);
		
		Y y = new Y();
		
		System.out.println(y.s);
		
		System.out.println(Y.s);
		
	}
}
