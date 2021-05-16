
class A {
	String doStuff(int x) {
		return "hello";
	}
}

public class B extends A{
	String doStuff(int kk) {
		return "BBBBB";
	}	
	
	public static void main(String[] args) {
		A[] as = new A[4];
		
		C c = new C();
		
		D d = new D();
		
		
		E e = new E();
		
		
		as[0] = c;
		as[1] = d;

		as[3] = e;
		
		System.out.println(as[0].doStuff(9));
		
		A a = new C();
		
		System.out.println(a.doStuff(0));
		
		C cc = (C) a;
		
		System.out.println(cc.onlyC(0));
		
	}
}

class C extends A{
	
	@Override
	String doStuff(int kk) {
		return "cccc";
	}	
	
	
	String onlyC(int c) {
		return "onlyC";
	}
}

class D extends A{
	String doStuff(int kk) {
		return "dddd";
	}	
}

class E extends A{
	String doStuff(int kk) {
		return "eeeee";
	}	
}

abstract class F{
	String doStuff(int kk) {
		return "fffff";
	}	
}

