package com.sirma.itt.javacourse.maven;

/**
 * Reverse the elements of array.
 * 
 * @version 1.1 08 April 2013
 * @author Stella Djulgerova
 */
public class ArrayReverse {

	/**
	 * Reverse the elements.
	 * 
	 * @param array - array to be reversed
	 * @return reversed array
	 */
	public int[] reverse(int[] array) {
		// switch elements while we hit the middle of array
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
		return array;
	}
}
