package com.sirma.itt.javacourse.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Replace first part of valid bulgarian IBAN numbers with ****.
 * 
 * @version 1.1 28 April 2013
 * @author Stella Djulgerova
 */
public class IBANFormatter {

	// class private members
	private Pattern pattern;
	private String output;
	
	// part of valid IBAN to replace
	private final String REGEX_PATTERN = "(BG)[0-9]{2}\\s*[A-Z]{4}\\s*[0-9]{4}";

	/**
	 * Class default constructor.
	 */
	public IBANFormatter(String regExPattern) {
		pattern = Pattern.compile(regExPattern);
	}
	
	/**
	 * Replace first part of valid IBAN number with ****.
	 * 
	 * @param input - string to be formated
	 * @return formated string
	 */
	public String format(String input) {
		
		Matcher regexMatcher = pattern.matcher(input);
		while (regexMatcher.find()) {
			output = input.replaceAll(regexMatcher.group(), regexMatcher.group().replaceAll(REGEX_PATTERN, "****"));
		}
		return output;
	}
}
