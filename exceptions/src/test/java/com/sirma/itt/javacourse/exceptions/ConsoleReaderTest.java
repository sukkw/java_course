package com.sirma.itt.javacourse.exceptions;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for console reader methods.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleReaderTest {
	private ConsoleReader reader = new ConsoleReader();

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { { "70", "70"}};
	}

	/**7
	 * Test calculate method.
	 * 
	 * @param string - string for validation
	 * @param valid - correct string
	 */
	@Test(dataProvider = "validData")
	public void validate(String string, String valid) {
		String result = reader.validate(string);
		Assert.assertEquals(result, valid);
	}
}
