package com.sirma.itt.javacourse.maven;

/**
 * Calculate greatest common divider and lowest common multiple of two numbers.
 * 
 * @version 1.1 08 April 2013
 * @author Stella Djulgerova
 */
public class NOD {

	/**
	 * Calculate greatest common divider of two numbers.
	 * 
	 * @param firstNumber - first number for calculation
	 * @param secondNumber - second number for calculation
	 * @return greatest common divider of two numbers
	 */
	public int nod(int firstNumber, int secondNumber) {
		int temp;
		do {
			if (firstNumber < secondNumber) {
				temp = firstNumber;
				firstNumber = secondNumber;
				secondNumber = temp;
			}
			firstNumber = firstNumber - secondNumber;
		} while (firstNumber != secondNumber);

		return firstNumber;
	}

	/**
	 * Calculate lowest common multiple of two numbers.
	 * 
	 * @param firstNumber - first number for calculation
	 * @param secondNumber - second number for calculation
	 * @return lowest common multiple of two numbers
	 */
	public int nok(int firstNumber, int secondNumber) {
		return (firstNumber * secondNumber) / nod(firstNumber, secondNumber);
	}
}
