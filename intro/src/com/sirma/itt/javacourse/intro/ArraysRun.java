package com.sirma.itt.javacourse.intro;

/**
 * Print array. Find the minimal element of array. Find the sum of array elements run class
 * 
 * @version 1.1 08 April 2013
 * @author Stella Djulgerova
 */
public class ArraysRun {

	/**
	 * Class main method.
	 * 
	 * @param arr
	 */
	public static void main(String[] arr) {
		Arrays arrs = new Arrays();
		int[] array = Helper.loadAray();
		Helper.printArray(array);
		System.out.println(" Sumata na chislata v masiva e: " + arrs.sumArray(array));
		System.out.println(" Naj-malkiq element v masiva e: " + arrs.getMinElement(array));
	}
}
