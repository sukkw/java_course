package com.sirma.itt.javacourse.intro;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Test class for find nod and nok.
 * 
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class NODTest {

	private NOD nod = new NOD();

	/**
	 * Data used for NOD tests.
	 * 
	 * @return object with data used for nod test
	 */
	@DataProvider
	public Object[][] validNODData() {
		return new Object[][] { { 16, 8, 8 }, { 21, 7, 7 }, { 21, 3, 3 } };
	}

	/**
	 * Data used for NOK tests.
	 * 
	 * @return object with data used for nok test
	 */
	@DataProvider
	public Object[][] validNOKData() {
		return new Object[][] { { 16, 8, 16 }, { 21, 7, 21 }, { 21, 7, 21 } };
	}

	/**
	 * Test for NOD.
	 * 
	 * @param firstNum - first number for calculation
	 * @param secondNum - second number for calculation
	 * @param valid - correct value for NOD of firstNum and secondNum
	 */
	@Test(dataProvider = "validNODData")
	public void nodTest(int firstNum, int secondNum, int valid) {
		int result = nod.nod(firstNum, secondNum);
		Assert.assertEquals(result, valid);
	}

	/**
	 * Test for NOK.
	 * 
	 * @param firstNum - first number for calculation
	 * @param secondNum - second number for calculation
	 * @param valid - correct value for NOK of firstNum and secondNum
	 */
	@Test(dataProvider = "validNOKData")
	public void nokTest(int firstNum, int secondNum, int valid) {
		int result = nod.nok(firstNum, secondNum);
		Assert.assertEquals(result, valid);
	}
}