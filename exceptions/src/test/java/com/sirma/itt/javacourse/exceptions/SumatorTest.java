package com.sirma.itt.javacourse.exceptions;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for sumator methods.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class SumatorTest {
	private Sumator sumator = new Sumator();

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { { "243", "567", "810" }, { "34567", "1256478", "1291045" },
				{ "74", "4567", "4641" } };
	}

	/**
	 * Test calculate method.
	 * 
	 * @param firstString - big number
	 * @param secondString - number to be added to firstString
	 * @param valid - correct sum of firstString and secondString
	 */
	@Test(dataProvider = "validData")
	public void calculate(String firstString, String secondString, String valid) {
		String result = sumator.calculate(firstString, secondString);
		Assert.assertEquals(result, valid);
	}
}
