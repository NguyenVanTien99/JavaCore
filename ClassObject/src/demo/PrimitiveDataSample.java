package demo;

 class PrimitiveDataSample {
	
	static String string;
	
	public void name() {
		System.out.println(string);
		String nString = this.toString();
	}
	
	
	 
	@Override
	public String toString() {
		return "PrimitiveDataSample [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}



	public static void main(String[] args) {
		System.out.println(string);
//		int number = 2017;
//		byte b = 23;
//		boolean checked = true;
//		float f = 23.5f;
//		double d = 34.5;
//		long l = 2021;
//		
//		String dataString = "xxx";
//		
//		
//		int x = 5;
//		short n = 4;
//		
//		n = (short) x;
//		
//		
//		int a = 5, z = 9;
//		
//		Integer c = null;
//		
//		c = new Integer(a) + new Integer(z) ;
//		int b = 9;
//		
//		double a = b;
//		
//		
//		
//		
//		
//		Long x = new Long(44);
//		Long x2 = new Long("44");
//		Short x3 = new Short("44");
//		
//		System.out.println(x == x2);
//		
//		System.out.println(x);
	
				
				
		

		
	} 
}
