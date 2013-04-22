package com.sirma.itt.javacourse.intro;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for weight center array.
 * 
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class ArrayCenterTest {

	private ArrayCenter testArray = new ArrayCenter();

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for test cases
	 */
	@DataProvider
	private Object[][] validData() {
		return new Object[][] { { new Integer[] { 1, 2, 3, 4, 5 }, 4 },
				{ new Integer[] { 7, 9, 3, 4, 1 }, 9 }, { new Integer[] { 4, 2, 2, 8, 6 }, 2 } };
	}

	/**
	 * Test calculation method.
	 * 
	 * @param array - array to find sum
	 * @param valid - correct sum of all elements
	 */
	@Test(dataProvider = "validData")
	public void calculateTast(Integer[] array, int valid) {
		int[] arr = new int[5];
		for (int i = 0; i < array.length; i++) {
			arr[i] = array[i];
		}

		int result = testArray.center(arr);
		Assert.assertEquals(result, valid);
	}
}
