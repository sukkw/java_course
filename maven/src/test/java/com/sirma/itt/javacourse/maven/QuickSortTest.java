package com.sirma.itt.javacourse.maven;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for quick sort.
 * 
 * @version 1.1 10 April 2013
 * @author Stella Djulgerova
 */
public class QuickSortTest {

	private int leftIndex = 0;
	private int rightIndex = 4;
	private QuickSort testSort = new QuickSort();

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	private Object[][] validData() {
		return new Object[][] {
				{ new Integer[] { 7, 2, 9, 4, 1 }, new Integer[] { 1, 2, 4, 7, 9 } },
				{ new Integer[] { 31, 9, 3, 11, 5 }, new Integer[] { 3, 5, 9, 11, 31 } },
				{ new Integer[] { 4, 2, 2, 8, 6 }, new Integer[] { 2, 2, 4, 6, 8 } } };
	}

	/**
	 * Test for quick sort method.
	 * 
	 * @param array - array to be sort
	 * @param valid - correct sorted array
	 */
	@Test(dataProvider = "validData")
	public void testSort(Integer[] array, Integer[] valid) {

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

		int[] result = testSort.sort(arr, leftIndex, rightIndex);
		Assert.assertEquals(result, val);
	}
}
