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
	private String output;
	
	/**
	 * Class constructor.
	 */
	public GreedyRegEx(String regExPattern) {
		if(regExPattern == null) {
			return;
		}
		pattern = Pattern.compile(regExPattern);
	}
	
	/**
	 * Replace characters in string with another string.
	 * 
	 * @param input - string to be formated
	 * @return formated string
	 */
	public String format(String input) {
		
		if (pattern == null || input == null) {
			return "Error in reg ex or input text";
		}
		Matcher regexMatcher = pattern.matcher(input);
		
		while (regexMatcher.find()) {
			output = input.replaceAll(regexMatcher.group(), "<x/>");
		}
		return output;
	}
}