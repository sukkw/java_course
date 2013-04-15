package com.sirma.itt.javacourse.intro;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for hangman game
 * 
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class HangTest {

	Hang hangTest = new Hang();

	/**
	 * Data used for tests
	 * 
	 * @return
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { { "------", 2, 'm', "--m---" } };
	}

	/**
	 * Test for char replace method
	 * 
	 * @param str
	 * @param pos
	 * @param ch
	 * @param valid
	 */
	@Test(dataProvider = "validData")
	public void replaceCharTest(String str, int pos, char ch, String valid) {
		String result = hangTest.replaceCharAt(str, pos, ch);
		Assert.assertEquals(result, valid);
	}
}
