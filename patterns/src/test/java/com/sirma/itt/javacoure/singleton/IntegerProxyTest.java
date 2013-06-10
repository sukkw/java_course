package com.sirma.itt.javacoure.singleton;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.proxy.IntegerProxy;
import com.sirma.itt.javacourse.proxy.Integer;

/**
 * Test class for proxy design pattern.
 * 
 * @version 1.1 10 June 2013
 * @author Stella Djulgerova
 */
public class IntegerProxyTest {

	private IntegerProxy proxyObject = new IntegerProxy();
	private Integer realObject = new Integer();

	/**
	 * Data used for add tests.
	 * 
	 * @return object with data used for add test
	 */
	@DataProvider
	public Object[][] validAddData() {
		return new Object[][] { { 10, 12, 22 }, { 2, 7, 9 }, { 21, 13, 34 } };
	}
	
	/**
	 * Data used for subtract tests.
	 * 
	 * @return object with data used for subtract test
	 */
	@DataProvider
	public Object[][] validSubtractData() {
		return new Object[][] { { 16, 8, 8 }, { 21, 7, 14 }, { 21, 3, 18 } };
	}
	
	/**
	 * Data used for multiply tests.
	 * 
	 * @return object with data used for multiply test
	 */
	@DataProvider
	public Object[][] validMultiplyData() {
		return new Object[][] { { 3, 8, 24 }, { 1, 7, 7 }, { 5, 3, 15 } };
	}
	
	/**
	 * Data used for divide tests.
	 * 
	 * @return object with data used for divide test
	 */
	@DataProvider
	public Object[][] validDivideData() {
		return new Object[][] { { 16, 8, 2 }, { 21, 7, 3 }, { 81, 9, 9 } };
	}
	
	/**
	 * Test for add method.
	 * 
	 * @param firstNum - first number for calculation
	 * @param secondNum - second number for calculation
	 * @param valid - valid result after addition 
	 */
	@Test(dataProvider = "validAddData")
	public void addTest(int firstNumber, int secondNumber, int valid) {
		int result = proxyObject.add(firstNumber, secondNumber);
		Assert.assertEquals(result, valid);
	}
	
	/**
	 * Test for subtract method.
	 * 
	 * @param firstNum - first number for calculation
	 * @param secondNum - second number for calculation
	 * @param valid - valid result after subtraction 
	 */
	@Test(dataProvider = "validSubtractData")
	public void subtractTest(int firstNumber, int secondNumber, int valid) {
		int result = proxyObject.subtract(firstNumber, secondNumber);
		Assert.assertEquals(result, valid);
	}
	
	/**
	 * Test for multiply method.
	 * 
	 * @param firstNum - first number for calculation
	 * @param secondNum - second number for calculation
	 * @param valid - valid result after multiplication 
	 */
	@Test(dataProvider = "validMultiplyData")
	public void multyTest(int firstNumber, int secondNumber, int valid) {
		int result = proxyObject.multy(firstNumber, secondNumber);
		Assert.assertEquals(result, valid);
	}
	
	/**
	 * Test for divide method.
	 * 
	 * @param firstNum - first number for calculation
	 * @param secondNum - second number for calculation
	 * @param valid - valid result after division 
	 */
	@Test(dataProvider = "validDivideData")
	public void divideTest(int firstNumber, int secondNumber, int valid) {
		int result = proxyObject.divide(firstNumber, secondNumber);
		Assert.assertEquals(result, valid);
	}
}
