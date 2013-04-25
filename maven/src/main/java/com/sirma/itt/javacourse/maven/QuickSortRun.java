package com.sirma.itt.javacourse.maven;

/**
 * Run QuickSort algorithm.
 * 
 * @version 1.1 09 April 2013
 * @author Stella Djulgerova
 */
public class QuickSortRun {

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = Helper.loadAray();

		QuickSort sort = new QuickSort();
		Helper.printArray(array);
		sort.sort(array, 0, array.length - 1);
		Helper.printArray(array);
	}
}
