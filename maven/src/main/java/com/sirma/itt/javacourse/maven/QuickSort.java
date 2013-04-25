package com.sirma.itt.javacourse.maven;

/**
 * Sort array using QuickSort algorithm.
 * 
 * @version 1.1 08 April 2013
 * @author Stella Djulgerova
 */
public class QuickSort {

	/**
	 * Sort an array.
	 * 
	 * @param array - array to be sorted
	 * @param leftIndex - position in array (0 at the beginning of sort)
	 * @param rightIndex - position in array (array size  at beginning of sort)
	 * @return sorted array
	 */
	public int[] sort(int[] array, int leftIndex, int rightIndex) {

		// return when we hit the middle of array
		if (leftIndex >= rightIndex) {
			return array;
		}

		int i = leftIndex;
		int j = rightIndex;
		int p = array[rightIndex];

		while (i < j) {
			// increase the value of i while the element at position i
			// is lower than element at last position
			while (i < j && array[i] <= p) {
				i++;
			}

			// decrease the value of j while the element at position j
			// is bigger than element at last position
			while (i < j && array[j] >= p) {
				j--;
			}

			// swap the elements
			if (i < j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;

			}
		}
		int t = array[i];
		array[i] = array[rightIndex];
		array[rightIndex] = t;

		// call the method again with the next array indexes
		sort(array, leftIndex, i - 1);
		sort(array, i + 1, rightIndex);

		return array;
	}

}
