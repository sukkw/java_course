package com.sirma.itt.javacourse.exceptions;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Test class for console reader methods.
 * 
 * @version 1.1 22 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleReaderTest {

	ConsoleReader reader = new ConsoleReader();

	/**
	 * Data used for console reader tests tests.
	 * 
	 * @return
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { { new String("16"), new String("16") } };
	}

	/**
	 * Test for validate method.
	 * 
	 * @param firstNum
	 * @param secondNum
	 * @param valid
	 */
	@Test(dataProvider = "validData")
	public void validate(String str, String validDate) {
		String result = reader.validate(str);
		Assert.assertEquals(result, validDate);
	}

	/**
	 * Test for read method.
	 * 
	 * @param firstNum
	 * @param secondNum
	 * @param valid
	 */
	@Test(dataProvider = "validData")
	public void read(String str, String validDate) {
		String result = reader.read();
		// Assert.assertEquals(result, validDate);
	}
}