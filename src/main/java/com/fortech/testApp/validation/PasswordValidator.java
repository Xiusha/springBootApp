package com.fortech.testApp.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fortech.testApp.dtos.UserDTO;

public class PasswordValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]{3,})(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{10,}$";


	public static boolean isValid(UserDTO user) {
		return (validatePassword(user));
	}
	
	private static boolean validatePassword(final UserDTO user) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(user.getPassword());
        return matcher.matches() && !containsUserDetails(user);
    }
	
	private static boolean containsUserDetails(UserDTO user) {
		String password = user.getPassword();
		if(containsIgnoreCase(password, user.getUsername())) {
			return true;
		}
		if(containsIgnoreCase(password, user.getGivenName())) {
			return true;
		}
		if(containsIgnoreCase(password, user.getGivenLastName())) {
			return true;
		}
		if(containsIgnoreCase(password, user.getPhone())) {
			return true;
		}
		return false;
	}
	
	public static boolean containsIgnoreCase(String str, String searchStr)     {
	    if(str == null || searchStr == null) return false;

	    final int length = searchStr.length();
	    if (length == 0)
	        return true;

	    for (int i = str.length() - length; i >= 0; i--) {
	        if (str.regionMatches(true, i, searchStr, 0, length))
	            return true;
	    }
	    return false;
	}

}
