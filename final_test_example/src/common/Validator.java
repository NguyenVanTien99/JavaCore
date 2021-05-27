package common;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private static final String VALID_PHONE_NUMBER_STRING = "^(090|098|091|031|035|038)\\d{7}$";

	// dd/mm/yyyy, dd-mm-yyyy or dd.mm.yyyy.
	// ^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$

	private static Pattern pattern;
	private static Matcher matcher;

	public static boolean isPhoneNumber(String phoneNumber) {
		pattern = Pattern.compile(VALID_PHONE_NUMBER_STRING);
		matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
	}

	public static boolean isFullName(String name) {
		if (name.length() >= 10 && name.length() <= 50) {
			return true;
		}

		return false;
	}

	public static boolean isDOB(String doB) {

//	   	String sDate1="31/12/1998";  
//	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
//	    System.out.println(sDate1+"\t"+date1);

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		try {
			dateTimeFormatter.parse(doB);
		} catch (DateTimeParseException e) {
			return false;
		}

		return true;

	}

	public static void main(String[] args) {

	}

}
