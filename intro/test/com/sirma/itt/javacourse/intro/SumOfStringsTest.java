package com.sirma.itt.javacourse.intro;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for sum of two strings methods.
 * 
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class SumOfStringsTest {

	private SumOfStrings str = new SumOfStrings();

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { { "9999", "8888", "18887" }, { "34567", "1256478", "1291045" },
				{ "74", "0", "74" } };
	}

	/**
	 * Test calculate method.
	 * 
	 * @param firstString - big number
	 * @param secondString - number to be added to firstString
	 * @param valid - correct sum of firstString and secondString
	 */
	@Test(dataProvider = "validData")
	public void calculateTast(String firstString, String secondString, String valid) {
		String result = str.calculate(firstString, secondString);
		Assert.assertEquals(result, valid);
	}
}
