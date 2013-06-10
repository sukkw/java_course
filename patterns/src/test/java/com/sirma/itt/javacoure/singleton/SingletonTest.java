package com.sirma.itt.javacoure.singleton;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.singleton.Singleton;

/**
 * Test class for singleton design pattern.
 * 
 * @version 1.1 10 June 2013
 * @author Stella Djulgerova
 */
public class SingletonTest {

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {

		// instance to be tested
		Singleton instance = Singleton.getInstance();

		return new Object[][] {
				{ instance }, { instance}, { instance } };
	}
	
	/**
	 * Test getInstance method. Only one instance must be created.
	 * 
	 * @param valid - correct instance
	 */
	@Test(dataProvider = "validData")
	public void orderInstances(Singleton singletonInstance) {
		Singleton newInstance = Singleton.getInstance();
		Assert.assertEquals(newInstance, singletonInstance);
	}
}
