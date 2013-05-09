package com.sirma.itt.javacourse.io;

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
	
	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { {80}};
	}

	/**7
	 * Test calculate method.
	 * 
	 * @param string - string for validation
	 * @param valid - correct string
	 */
	@Test(dataProvider = "validData")
	public void validate(int valid) {
		int enteredInt = ConsoleReader.readInt();
		Assert.assertEquals(enteredInt, valid);
	}
}
