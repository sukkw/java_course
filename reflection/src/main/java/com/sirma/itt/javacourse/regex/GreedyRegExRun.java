package com.sirma.itt.javacourse.regex;

import java.util.regex.PatternSyntaxException;

/**
 * GreedyRegEx run class.
 * 
 * @version 1.1 29 April 2013
 * @author Stella Djulgerova
 */
public class GreedyRegExRun {

	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// string for format
		String stringToFormat = "<x><b></b><x>Hello world</x>" 
				+ "<b>sdfsdf</b><x>Good "
				+ "morning</x><x>69</x><x>sdfsdfsdf</x>" 
				+ "</x>";

		// regular expression pattern
		// String greedyRegEx = "(<x>).*?(</x>)";
		String negatedRegEx = "(<x>)[^(</x>)]*(</x>)";

		try {
			GreedyRegEx greedy = new GreedyRegEx(negatedRegEx);
			stringToFormat = greedy.format(stringToFormat);
			System.out.println(stringToFormat);
		} catch (PatternSyntaxException e) {
			System.out.println("Error in reg ex pattern");
		}
	}
}
