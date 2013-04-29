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
	
	// valid email regular expression pattern
	private final String EMAIL_PATTERN = 
		"[A-Za-z]+([A-Za-z0-9-.])+@[A-Za-z]+([A-Za-z0-9-.])+(.[A-Za-z]{2,})";
 
	/**
	 * Class default constructor.
	 */
	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}
 
	/**
	 * Validate email with regular expression.
	 * 
	 * @param email - email for validation
	 * @return true valid email or false invalid email
	 */
	public boolean validate(String email) {
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
