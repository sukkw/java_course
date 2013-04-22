package com.sirma.itt.javacourse.intro;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for hangman game.
 * 
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class HangTest {

	private Hang hangTest = new Hang();

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for sum test
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { { "------", 2, 'm', "--m---" } };
	}

	/**
	 * Test for char replace method.
	 * 
	 * @param str - string where to replace
	 * @param pos - position in string
	 * @param ch - char to be replace
	 * @param valid - string with correct replaced value
	 */
	@Test(dataProvider = "validData")
	public void replaceCharTest(String str, int pos, char ch, String valid) {
		String result = hangTest.replaceCharAt(str, pos, ch);
		Assert.assertEquals(result, valid);
	}
}
