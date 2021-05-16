package as_702.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import as_702.exceptions.GeneralException;



public class validator {
	private static final String VALID_EMAIL_RG = "^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$";
	private static final String VALID_THEORY_PRACTICE_RG = "^([1-9]|10)$";
	private static final String VALID_DD_MM_YYYY_RG = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
	
	private static Pattern pattern;
	
	private static Matcher matcher;
	
	public static void validatEmail(String email) throws GeneralException{
		pattern = Pattern.compile(VALID_EMAIL_RG);
		matcher = pattern.matcher(email);
		if(matcher.matches() == false) {
			throw new GeneralException("email not valid");
		}
	}
	
	public static void validateTheoryOrPractice(String theoryOrPractice) throws GeneralException{
		pattern = Pattern.compile(VALID_THEORY_PRACTICE_RG);
		matcher = pattern.matcher(theoryOrPractice);
		if(matcher.matches() == false) {
			throw new GeneralException("Value: range from 0 to 10.");
		}
	}
	
	public static void validateDayOfBirth(String dayOfBirth) throws GeneralException{
		pattern = Pattern.compile(VALID_DD_MM_YYYY_RG);
		matcher = pattern.matcher(dayOfBirth);
		if(matcher.matches() == false) {
			throw new GeneralException("Day of birth has a format DD/MM/YYYY");
		}
	}
}
