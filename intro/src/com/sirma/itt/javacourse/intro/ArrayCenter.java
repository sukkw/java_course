package com.sirma.itt.javacourse.intro;

/**
 * Find the weight center of array
 * 
 * @version 1.1 08 April 2013
 * @author Stella Djulgerova
 */
public class ArrayCenter {

	/**
	 * find the element which is the weight center of array
	 * 
	 * @param array
	 * @return position and value of weight center element
	 */
	public int center(int[] array) {
		int i;
		int j;

		// hold the sum from first element of array to the weight center
		int leftSum = 0;

		// hold the sum from last element of array to the weight center
		int rightSum = 0;

		for (i = 0, j = array.length - 1; i < j;) {
			if (leftSum < rightSum) {
				leftSum += array[i++];
			} else {
				rightSum += array[j--];
			}
		}

		return array[i];
	}
}
