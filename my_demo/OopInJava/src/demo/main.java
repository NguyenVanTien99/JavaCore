package demo;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add(0, "Array");
		list.add(0,"1");list.add(1,"2");
		
		System.out.println(list);
	}

}
