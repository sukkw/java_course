package com.sirma.itt.javacourse.intro;

import java.util.Random;

/**
 * Helper class with common functions.
 * 
 * @version 1.1 08 April 2013
 * @author Stella Djulgerova
 */
public class Helper {

	/**
	 * Load random values in array.
	 * 
	 * @return array of integers
	 */
	public static int[] loadAray(int arraySize) {
		// declares an array of integers
		int[] array  = new int[arraySize];

		// call java class Random to generate numbers
		Random randomGenerator = new Random();

		// put random numbers in array
		for (int i = 0; i < arraySize; i++) {
			array[i] = randomGenerator.nextInt(100);
		}
		return array;
	}

	/**
	 * Print all elements of array.
	 * 
	 * @param array - array to be print.
	 */
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(" Element " + i + " = " + array[i]);
		}
	}
}