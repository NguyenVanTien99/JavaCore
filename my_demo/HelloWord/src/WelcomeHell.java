import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sun.jdi.Value;

public class WelcomeHell extends F {

	public static int name(int k) {
		int j = 1;
		
		switch (k) {
		case 1:j++;
		case 2:j++;
		case 3:j++;
		case 4:j++;
		default:j++;
		}
		
		return j +k;		
	}
	
	public static void main(String[] args) {
		int x = 10; 
		
		{
			
			int y =20;
			System.out.println(x + ", " + y);
		}
		
		{

			
			
		}
		
		
	}

}			
