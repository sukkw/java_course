package com.sirma.itt.javacourse.intro;

import java.util.Random;

/**
 * Calculate greatest common divider and lowest common multiple of two numbers run class.
 * 
 * @version 1.1 09 April 2013
 * @author Stella Djulgerova
 */
public class NODRun {

	/**
	 * Class main method.
	 * 
	 * @param arr
	 */
	public static void main(String[] arr) {
		// call java class Random to generate numbers
		Random randomGenerator = new Random();

		int firstNumber = randomGenerator.nextInt(50);
		int secondNumber = randomGenerator.nextInt(50);

		NOD nod = new NOD();
		System.out.println("NOD na " + firstNumber + " i " + secondNumber + " e: "
				+ nod.nod(firstNumber, secondNumber));
		System.out.println("NOK na " + firstNumber + " i " + secondNumber + " e: "
				+ nod.nok(firstNumber, secondNumber));
	}
}
