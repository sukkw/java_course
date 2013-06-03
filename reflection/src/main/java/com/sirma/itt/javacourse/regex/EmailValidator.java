package com.sirma.itt.javacourse.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Validate email with regular expression.
 * 
 * @version 1.1 28 April 2013
 * @author Stella Djulgerova
 */
public class EmailValidator {
	 
	// class private members
	private Pattern pattern;
	private Matcher matcher;
	
	/**
	 * Class default constructor.
	 */
	public EmailValidator(String regExPattern) {
		if(regExPattern == null) {
			return;
		}
		pattern = Pattern.compile(regExPattern);
	}
 
	/**
	 * Validate email with regular expression.
	 * 
	 * @param email - email for validation
	 * @return true valid email or false invalid email
	 */
	public boolean validate(String email) {
		if (pattern == null || email == null) {
			return false;
		}
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
