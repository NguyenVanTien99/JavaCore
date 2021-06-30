package common;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.invalidPDateException;
import exception.invalidPYearException;
import exception.invalidPublisherEception;

public class Validator {

	private static final String VALID_PHONE_NUMBER_STRING = "^(090|098|091|031|035|038)\\d{7}$";
	
	private static final String VALID_PUBLISHER = "^[A-Za-z ]+$";

	/*
	 * dd/mm/yyyy, dd-mm-yyyy or dd.mm.yyyy.
	 * ^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0
	 * -2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-
	 * 9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))
	 * )$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[
	 * 2-9]\d)?\d{2})$
	 */

	private static Pattern pattern;
	private static Matcher matcher;

	public static void validatePDate(String PDate) throws invalidPDateException {

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			dateTimeFormatter.parse(PDate);
		} catch (DateTimeParseException e) {
			throw new invalidPDateException("PDate is invalid");
		}

	}
	
	public static void validatePYear(String PYear) throws invalidPYearException {
		if (Integer.parseInt(PYear) < 2000) {
			throw new invalidPYearException("PYear is invalid");
		}
      
    }
	
	public static void validatePublisher(String publisher) throws invalidPublisherEception {
        pattern = Pattern.compile(VALID_PUBLISHER);
        matcher = pattern.matcher(publisher);
        if(!matcher.matches()){
            throw new invalidPublisherEception("Publisher onlycharacter");
        }
    }

}
