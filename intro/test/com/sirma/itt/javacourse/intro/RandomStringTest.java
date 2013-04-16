package com.sirma.itt.javacourse.intro;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for random string generation test.
 *
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class RandomStringTest {

	SumOfStrings str = new SumOfStrings();
	
	@DataProvider
	public Object[][] validData() {
		return new Object[][]{};
	}

	@Test(dataProvider = "validData")
	public void f() {
	}
}
