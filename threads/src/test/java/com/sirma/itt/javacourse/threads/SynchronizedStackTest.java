package com.sirma.itt.javacourse.threads;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for synchronized stack methods.
 * 
 * @version 1.1 10 June 2013
 * @author Stella Djulgerova
 */
public class SynchronizedStackTest {
	
	/**
	 * Data used for add element tests.
	 * 
	 * @return object with data used for add element tests
	 */
	@DataProvider
	public Object[][] validAddData() {
		return new Object[][] { { new Object[] { 4, 9, null, null, null }, 8,
				new Object[] { 4, 9, 8, null, null } }

		};
	}

	/**
	 * Data used for remove element tests.
	 * 
	 * @return object with data used for remove element tests
	 */
	@DataProvider
	public Object[][] validRemoveData() {
		return new Object[][] { { new Object[] { 4, 9, 12, 5, null }, 
				new Object[] { 1, 2, 12, null, null } }

		};
	}

	/**
	 * Test add method.
	 * 
	 * @param elToAdd - array of elements
	 * @param elementToAdd - element to be added in elList
	 * @param valid - valid result after element is added
	 */
	@Test(dataProvider = "validAddData")
	public void add(Object[] elList, Object elToAdd, Object[] valid) {
		
	}

	/**
	 * Test remove method.
	 * 
	 * @param elList - array of elements
	 * @param valid - valid result after element is removed
	 */
	@Test(dataProvider = "validRemoveData")
	public void remove(Object[] elList, Object[] valid) {

	}
}
