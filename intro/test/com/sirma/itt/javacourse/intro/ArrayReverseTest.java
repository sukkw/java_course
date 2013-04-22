package com.sirma.itt.javacourse.intro;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for reverse array methods.
 * 
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class ArrayReverseTest {

	private ArrayReverse reverseTest = new ArrayReverse();

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for test cases
	 */
	@DataProvider
	private Object[][] validData() {
		return new Object[][] {
				{ new Integer[] { 1, 2, 3, 4, 5 }, new Integer[] { 5, 4, 3, 2, 1 } },
				{ new Integer[] { 7, 9, 3, 4, 1 }, new Integer[] { 1, 4, 3, 9, 7 } },
				{ new Integer[] { 4, 2, 2, 8, 6 }, new Integer[] { 6, 8, 2, 2, 4 } } };
	}

	/**
	 * Test method reverse.
	 * 
	 * @param array - array to be reversed
	 * @param valid - correct reversed array
	 */
	@Test(dataProvider = "validData")
	public void reverseTest(Integer[] array, Integer[] valid) {

		// change from array of Integers to array of int.
		// TestNG works only with objects
		int[] arr = new int[5];
		for (int i = 0; i < array.length; i++) {
			arr[i] = array[i];
			System.out.print(array[i]);
		}
		System.out.println();

		// change from array of Integers to array of int.
		// TestNG works only with objects
		int[] val = new int[5];
		for (int i = 0; i < valid.length; i++) {
			val[i] = valid[i];
			System.out.print(val[i]);
		}
		System.out.println();

		int[] result = reverseTest.reverse(arr);
		Assert.assertEquals(result, valid);
	}
}
