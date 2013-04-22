package com.sirma.itt.javacourse.exceptions;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for sumator methods.
 * 
 * @version 1.1 20 April 2013
 * @author Stella Djulgerova
 */
public class SumatorTest {

	Sumator sumator = new Sumator();

	/**
	 * Data used for tests.
	 * 
	 * @return
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { { "9999", "8888", "18887" }, { "34567", "1256478", "1291045" },
				{ "74", "0", "74" } };
	}

	/**
	 * Test calculate method.
	 * 
	 * @param firstString
	 * @param secondString
	 * @param valid
	 */
	@Test(dataProvider = "validData")
	public void calculateTast(String firstString, String secondString, String valid) {
		String result = sumator.calculate(firstString, secondString);
		Assert.assertEquals(result, valid);
	}

	/**
	 * Test calculate method.
	 * 
	 * @param firstString
	 * @param secondString
	 * @param valid
	 */
	@Test(dataProvider = "validData")
	public void validate(String firstString, String secondString, String valid) {
		/*
		 * String result = sumator.validate("fr"); Assert.assertEquals(result, valid);
		 */
	}

}
