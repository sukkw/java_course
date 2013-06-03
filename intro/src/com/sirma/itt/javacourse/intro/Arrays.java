package com.sirma.itt.javacourse.intro;

/**
 * Print array. Find the minimal element of array. 
 * Find the sum of array elements.
 * 
 * @version 1.1 08 April 2013
 * @author Stella Djulgerova
 */
public class Arrays {

	/**
	 * Calculate sum of all elements in array and print the result.
	 * 
	 * @param array - array to find sum
	 * @return sum of all elements in array
	 */
	public int sumArray(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		return sum;
	}

	/**
	 * find the value of minimal element in array.
	 * 
	 * @param array - array to find minimal element
	 * @return minimal element in array
	 */
	public int getMinElement(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}

		return min;
	}
}