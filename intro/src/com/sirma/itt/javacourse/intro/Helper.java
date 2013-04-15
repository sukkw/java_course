package com.sirma.itt.javacourse.intro;

import java.util.Random;

public class Helper {
	/**
	 * Load random values in array with size of 5 elements
	 * 
	 * @return array of integers
	 */
	public static int[] loadAray() {
		// declares an array of integers
		int[] array;

		// allocates memory for 5 integers
		array = new int[5];

		// call java class Random to generate numbers
		Random randomGenerator = new Random();

		// put random numbers in array
		for (int i = 0; i < 5; i++) {
			array[i] = randomGenerator.nextInt(100);
		}
		return array;
	}

	/**
	 * print all elements of array
	 * 
	 * @param array
	 */
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(" Element " + i + " = " + array[i]);
		}
	}
}
