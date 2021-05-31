package as_501;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private static final String VALID_CODE_RG = "FW\\d{3}";
	private static final String VALID_STATUS_RG = "^(active|in-active)$";
	private static final String VALID_FLAG_RG = "^(optional|mandatory|N\\/A)$";
	
	private static Pattern pattern;
	
	private static Matcher matcher;
	
	/**
	 * Check code follow the pattern
	 * 
	 * @method validateCode
	 * 
	 * @param code
	 * 
	 * @return true if code is valid, else false
	 */
	public static void validateCode(String code) throws GeneralException{
		pattern = Pattern.compile(VALID_CODE_RG);
		matcher = pattern.matcher(code);
		if(matcher.matches() == false) {
			throw new GeneralException("Course code has a format FWXXX(X : 0 -9)");
		}
	}
	/**
	 * Check status follow the pattern
	 * 
	 * @method validateStatus
	 * 
	 * @param status
	 * 
	 * @return true if status is valid, else false
	 */
	public static void validateStatus(String status) throws GeneralException{
		pattern = Pattern.compile(VALID_STATUS_RG);
		matcher = pattern.matcher(status);
		if(matcher.matches() == false) {
			throw new GeneralException("Value: active/in-active");
		}
	}
	/**
	 * Check flag follow the pattern
	 * 
	 * @method validateFlag
	 * 
	 * @param flag
	 * 
	 * @return true if flag is valid, else false
	 */
	public static void validateFlag(String flag) throws GeneralException{
		pattern = Pattern.compile(VALID_FLAG_RG);
		matcher = pattern.matcher(flag);
		if(matcher.matches() == false) {
			throw new GeneralException("Value: optional-mandatory-N/A");
		}
	}
	
}
