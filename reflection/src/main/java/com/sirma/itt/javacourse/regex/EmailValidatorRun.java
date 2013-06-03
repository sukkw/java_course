package com.sirma.itt.javacourse.regex;

import java.util.regex.PatternSyntaxException;

/**
 * EmailValidator run class.
 * 
 * @version 1.1 28 April 2013
 * @author Stella Djulgerova
 */
public class EmailValidatorRun {

	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			// valid email regular expression pattern
			String regExPattern = 
				"[A-Za-z]+([A-Za-z0-9-.])+@[A-Za-z]+([A-Za-z0-9-.])+(.[A-Za-z]{2,})";
		 
			EmailValidator validator = new EmailValidator(regExPattern);

			String email = "te.s99st.t-s.@dsda.sdss.sdasd.dd";

			if (validator.validate(null)) {
				System.out.println("Valid email");
			} else {
				System.out.println("Invalid email");
			}
		} catch (PatternSyntaxException e) {
			System.out.println("Error in reg ex pattern");
		}
	}
}