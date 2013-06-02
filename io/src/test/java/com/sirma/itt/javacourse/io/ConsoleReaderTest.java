package com.sirma.itt.javacourse.io;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for console reader methods.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleReaderTest {
	
	/**
	 * Data used for strings tests.
	 * 
	 * @return object with data used for string tests
	 */
	@DataProvider
	public Object[][] validStringData() {
		return new Object[][] { {"test"}};
	}
	
	/**
	 * Data used for integer tests.
	 * 
	 * @return object with data used for integers tests
	 */
	@DataProvider
	public Object[][] validIntData() {
		return new Object[][] { {12}};
	}
	
	/**
	 * Data used for float tests.
	 * 
	 * @return object with data used for float tests
	 */
	@DataProvider
	public Object[][] validFloatData() {
		return new Object[][] { {8.56f}};
	}
	
	/**
	 * Data used for char tests.
	 * 
	 * @return object with data used for char tests
	 */
	@DataProvider
	public Object[][] validCharData() {
		return new Object[][] { {'a'}};
	}

	/**
	 * Test read string method.
	 * 
	 * @param valid - correct string
	 */
	@Test(dataProvider = "validStringData")
	public void testReadString(String valid) {
		System.out.println("S");
		String enteredString = ConsoleReader.readString();
		Assert.assertEquals(enteredString, valid);
	}
	
	/**
	 * Test read integer method.
	 * 
	 * @param valid - correct digit
	 */
	@Test(dataProvider = "validIntData")
	public void testReadInt(int valid) {
		System.out.println("I");
		int enteredInt = ConsoleReader.readInt();
		Assert.assertEquals(enteredInt, valid);
	}
	
	/**
	 * Test read float method.
	 * 
	 * @param valid - correct float value
	 */
	@Test(dataProvider = "validFloatData")
	public void testReadFloat(float valid) {
		System.out.println("F");
		float enteredFloat = ConsoleReader.readFloat();
		Assert.assertEquals(enteredFloat, valid);
	}
	
	/**
	 * Test read char method.
	 * 
	 * @param valid - correct char
	 */
	@Test(dataProvider = "validCharData")
	public void validate(char valid) {
		System.out.println("C");
		char enteredChar = ConsoleReader.readChar();
		Assert.assertEquals(enteredChar, valid);
	}
}
