package as_901.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private static final String VALID_PHONE_REGEX = "^\\d{10,}$"; 
	private static final String VALID_ORDER_ID_REGEX = "^\\d{10}$";  
	  
	private static Set<String> ids = new HashSet<String>();  
	
	private static Pattern pattern;
	private static Matcher matcher;
	
	public static boolean isPhone(String phone) {
		pattern = Pattern.compile(VALID_PHONE_REGEX);
		matcher = pattern.matcher(phone);
		return matcher.matches();		
	}
	
	public static boolean isOrderNumber(String number) {
		pattern = Pattern.compile(VALID_ORDER_ID_REGEX);
		matcher = pattern.matcher(number);
		return matcher.matches();		
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
	
	public static boolean isExisted(String id) {
		if(!ids.contains(id)) {
			ids.add(id);
			return true;
		} else {
			return false;
		}
	}
	
	public static Set<String> getIds() {
		return ids;
	}
}
