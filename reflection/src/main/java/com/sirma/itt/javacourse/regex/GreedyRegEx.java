package com.sirma.itt.javacourse.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Replace parts of a string with another string using greedy regex.
 * 
 * @version 1.1 29 April 2013
 * @author Stella Djulgerova
 */
public class GreedyRegEx {

	// class private members
	private Pattern pattern;
	
	/**
	 * Class default constructor.
	 */
	public GreedyRegEx(String regExPattern) {
		pattern = Pattern.compile(regExPattern);
	}
	
	/**
	 * Replace characters in string with another string.
	 * 
	 * @param stringToFormat - string to be formated
	 * @return formated string
	 */
	public String format(String stringToFormat) {
		
		Matcher regexMatcher = pattern.matcher(stringToFormat);
		
		while (regexMatcher.find()) {
			stringToFormat = stringToFormat.replaceAll(regexMatcher.group(), "<x/>");
		}
		return stringToFormat;
	}
}
