package com.sirma.itt.javacourse.regex;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for Greedy RegEx methods.
 * 
 * @version 1.1 29 April 2013
 * @author Stella Djulgerova
 */
public class GreedyRegExTest {

	// class private members
	private String regExPattern = "(<x>)[^(</x>)]*(</x>)";
	private GreedyRegEx greedy = new GreedyRegEx(regExPattern);

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { {
				"<x><b></b><x>Hello world</x><b>sdfsdf</b><x>Good "
						+ "morning</x><x>69</x><x>sdfsdfsdf</x></x>",
				"<x><b></b><x/><b>sdfsdf</b><x/><x/><x/></x>" },
				{
					"<x><b></b><x>Hello world</x><b>sdfsdf</b><x>Good "
							+ "morning</x><x>69</x><x>sdfsdfsdf</x><a>ss</a>" +
							"<x>Upss</x></br></x>",
					"<x><b></b><x/><b>sdfsdf</b><x/><x/><x/><a>ss</a><x/></br></x>" }};
	}

	/**
	 * Test format method.
	 * 
	 * @param stringToFormat - string to be formated
	 * @param valid - correct formatted string
	 */
	@Test(dataProvider = "validData")
	public void format(String stringToFormat, String valid) {
		String result = greedy.format(stringToFormat);
		Assert.assertEquals(result, valid);
	}
}
