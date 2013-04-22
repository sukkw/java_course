package com.sirma.itt.javacourse.intro;

/**
 * Reverse the elements of array run class.
 * 
 * @version 1.1 09 April 2013
 * @author Stella Djulgerova
 */
public class ArrayReverseRun {

	/**
	 * Class main method.
	 * 
	 * @param arr
	 */
	public static void main(String[] arr) {

		int[] array = Helper.loadAray();
		ArrayReverse arrRev = new ArrayReverse();
		Helper.printArray(array);
		arrRev.reverse(array);
		Helper.printArray(array);
	}
}
