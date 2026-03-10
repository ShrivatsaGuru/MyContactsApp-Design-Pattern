package validation;

import java.util.regex.Pattern;

import exceptions.InvalidUserData;
public class InputValidation {
	
	public static final String email_regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	public static final Pattern email_pattern = Pattern.compile(email_regex);
	
	public static void validateEmail(String email) throws Exception{
		if (email == null || !email_pattern.matcher(email).matches()) {
			throw new InvalidUserData("Invalid email format!");
	    }
	}
	
	public static void validatePassword(String password) throws Exception{
		if (password == null || password.length()<8) {
			throw new InvalidUserData("Password should have atleast 8 characters!");
		}
	}
}