package as_1001.common;

import java.util.regex.Pattern;

public class Validator {
	public static boolean isValidBillCode(String billCode) {
		return Pattern.matches("^(B)[0-9]{4}$", billCode);
	}
	
	public static double isDouble(String number) {
		double d = 0d;
		try {
			d = Double.parseDouble(number); 
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
		return d;		
	}
	
	public static int isInt(String number) {
		int i = 0;
		try {
			i = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
		return i;		
	}
	
}
