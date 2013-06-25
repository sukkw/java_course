package com.sirma.itt.javacourse.gui;

import java.lang.reflect.Field;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.sirma.itt.javacourse.gui.calc.Calculator;

public class CalculatorTest {

	private Calculator calc = new Calculator();

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for test
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { { "16", "8", "+", "24" }, 
				{ "16", "8", "-", "8" }, 
				{ "8", "8", "*", "64" }, 
				{ "66", "5", "/", "13.2" }};
	}

	/**
	 * Test calculate method.
	 * 
	 * @param firstNum - first number for calculation
	 * @param secondNum - second number for calculation
	 * @param valid - correct value after add operation
	 */
	@Test(dataProvider = "validData")
	public void calculateTest(String firstNum, String secondNum, String operator, String valid) {
		StringBuilder firstNumber = new StringBuilder();
		StringBuilder secondNumber = new StringBuilder();
		try {
			Field f = calc.getClass().getDeclaredField("operator");
			f.setAccessible(true);
			f.set(calc, operator);
			f.setAccessible(false);
			
			f = calc.getClass().getDeclaredField("firstNumber");
			f.setAccessible(true);
			firstNumber.append(firstNum);
			f.set(calc, firstNumber);
			f.setAccessible(false);
			
			f = calc.getClass().getDeclaredField("secondNumber");
			f.setAccessible(true);
			secondNumber.append(secondNum);
			f.set(calc, secondNumber);
			f.setAccessible(false);
			
			String result = calc.calculate();
			Assert.assertEquals(result, valid);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}