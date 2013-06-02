package com.sirma.itt.javacourse.collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for throw dice methods.
 * 
 * @version 1.1 10 May 2013
 * @author Stella Djulgerova
 */
public class DiceTest {

	/**
	 * Data used for throw dice tests.
	 * 
	 * @return object with data used for throw dice tests
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] { {"MariqElica"}};
	}
	
	/**
	 * Test file reverse method.
	 * 
	 * @param valid - valid data
	 */
	@Test(dataProvider = "validData")
	public void testFileReverse(String valid) {


			//Assert.assertEquals(str.toString(), valid);
	}
}
