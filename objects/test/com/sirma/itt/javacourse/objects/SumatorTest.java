package com.sirma.itt.javacourse.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for sum of different data types.
 * 
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class SumatorTest {

	Sumator sumator = new Sumator();

	/**
	 * Data used for int tests.
	 * 
	 * @return object with data used for integer sum tests
	 */
	@DataProvider
	public Object[][] validIntData() {
		return new Object[][] { { 16, 8, 24 }, { 21, 7, 28 }, { 21, 3, 24 } };
	}

	/**
	 * Data used for float tests.
	 * 
	 * @return object with data used for float sum tests
	 */
	@DataProvider
	public Object[][] validFloatData() {
		return new Object[][] { { 3.5f, 6.7f, 10.2f }, { 2.6f, 1.5f, 4.1f },
				{ 214.455f, 3.3f, 217.755f } };
	}

	/**
	 * Data used for string tests.
	 * 
	 * @return object with data used for string sum tests
	 */
	@DataProvider
	public Object[][] validStringData() {
		return new Object[][] { { "9999", "8888", "18887" }, { "34567", "1256478", "1291045" },
				{ "74", "0", "74" } };
	}

	/**
	 * Data used for BigInteger tests.
	 * 
	 * @return object with data used for big integer sum tests
	 */
	@DataProvider
	public Object[][] validBigIntData() {
		return new Object[][] { { new BigInteger("7"), new BigInteger("4"), new BigInteger("11") },
				{ new BigInteger("12"), new BigInteger("5"), new BigInteger("17") },
				{ new BigInteger("13"), new BigInteger("6"), new BigInteger("19") } };
	}

	/**
	 * Data used for BigDecimal tests.
	 * 
	 * @return object with data used for big decimal sum tests
	 */
	@DataProvider
	public Object[][] validBigDecData() {
		return new Object[][] {
				{ new BigDecimal(2.548), new BigDecimal(3.5), new BigDecimal(6.048) },
				{ new BigDecimal(8.678), new BigDecimal(2.811), new BigDecimal(11.489) } };
	}

	/**
	 * Test for int calculation.
	 * 
	 * @param firstNum - first integer number to sum
	 * @param secondNum - second integer number to sum
	 * @param valid - correct sum of firstNum and secondNum
	 */
	@Test(dataProvider = "validIntData")
	public void sumTest(int a, int b, int valid) {
		int result = sumator.sum(a, b);
		Assert.assertEquals(result, valid);
	}

	/**
	 * Test for float calculation.
	 * 
	 * @param firstNum - first float number to sum
	 * @param secondNum - second float number to sum
	 * @param valid - correct sum of firstNum and secondNum
	 */
	@Test(dataProvider = "validFloatData")
	public void sumTest(float a, float b, float valid) {
		float result = sumator.sum(a, b);
		Assert.assertEquals(result, valid);
	}

	/**
	 * Test for String calculation.
	 * 
	 * @param firstNum - first string number to sum
	 * @param secondNum - second string number to sum
	 * @param valid - correct sum of firstNum and secondNum
	 */
	@Test(dataProvider = "validStringData")
	public void sumTest(String a, String b, String valid) {
		String result = sumator.sum(a, b);
		Assert.assertEquals(result, valid);
	}

	/**
	 * Test for BigInteger calculation.
	 * 
	 * @param firstNum - first big integer number to sum
	 * @param secondNum - second big integer number to sum
	 * @param valid - correct sum of firstNum and secondNum
	 */
	@Test(dataProvider = "validBigIntData")
	public void sumTest(BigInteger a, BigInteger b, BigInteger valid) {
		BigInteger result = sumator.sum(a, b);
		Assert.assertEquals(result, valid);
	}

	/**
	 * Test for BigDecimal calculation.
	 * 
	 * @param firstNum - first big decimal number to sum
	 * @param secondNum - second big decimal number to sum
	 * @param valid - correct sum of firstNum and secondNum
	 */
	@Test(dataProvider = "validBigDecData")
	public void sumTest(BigDecimal a, BigDecimal b, BigDecimal valid) {
		BigDecimal result = sumator.sum(a, b);
		Assert.assertEquals(result, valid.setScale(3, BigDecimal.ROUND_UP));
	}
}
