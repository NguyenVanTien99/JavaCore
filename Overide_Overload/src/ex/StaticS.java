package ex;

public class StaticS {
	
	static int x = 10;
	
	static {
		
		x+= 5;
		
	}
	
	
	public static void main(String[] args) {
		int x1 = 5;
		int x2 = --x1;
		
		System.out.println(x1);
		System.out.println(x2);
		
	}
	
	
	static {
		
		x+= 9;
		
	}

}


class tien {
	static int si = 10;
	int i;
	final boolean bool;
	
	{
		bool = (si > 5);
	}
}
