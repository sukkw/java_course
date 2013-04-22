package com.sirma.itt.javacourse.intro;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for array methods.
 * 
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class ArraysTest {

	private Arrays testArray = new Arrays();

	/**
	 * Data used for sum tests.
	 * 
	 * @return
	 */
	@DataProvider
	public Object[][] validSumData() {
		return new Object[][] { { new Integer[] { 1, 2, 3, 4, 5 }, 15 },
				{ new Integer[] { 8, 2, 4, 4, 7 }, 25 }, { new Integer[] { 9, 2, 1, 4, 7 }, 23 } };
	}

	/**
	 * Data used for min element tests.
	 * 
	 * @return
	 */
	@DataProvider
	public Object[][] validMinData() {
		return new Object[][] { { new Integer[] { 1, 2, 3, 4, 5 }, 1 },
				{ new Integer[] { 8, 2, 4, 4, 7 }, 2 }, { new Integer[] { 9, 6, 8, 4, 7 }, 4 } };
	}

	/**
	 * Test for sum method.
	 * 
	 * @param array
	 * @param valid
	 */
	@Test(dataProvider = "validSumData")
	public void sumTest(Integer[] array, int valid) {

		// change from array of Integers to array of int.
		// TestNG works only with objects
		int[] arr = new int[5];
		for (int i = 0; i < array.length; i++) {
			arr[i] = array[i];
		}

		int result = testArray.sumArray(arr);
		Assert.assertEquals(result, valid);
	}

	/**
	 * Test for find min element method.
	 * 
	 * @param array
	 * @param valid
	 */
	@Test(dataProvider = "validMinData")
	public void minTest(Integer[] array, int valid) {

		// change from array of Integers to array of int.
		// TestNG works only with objects
		int[] arr = new int[5];
		for (int i = 0; i < array.length; i++) {
			arr[i] = array[i];
		}

		int result = testArray.getMinElement(arr);
		Assert.assertEquals(result, valid);
	}
}
