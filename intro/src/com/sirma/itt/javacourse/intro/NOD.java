package com.sirma.itt.javacourse.intro;

/**
 * Calculate greatest common divider and lowest common multiple of two numbers.
 * 
 * @version 1.1 08 April 2013
 * @author Stella Djulgerova
 */
public class NOD {

	/**
	 * calculate greatest common divider of two numbers.
	 * 
	 * @param firstNumber
	 * @param secondNumber
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
	 * calculate lowest common multiple of two numbers.
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return lowest common multiple of two numbers
	 */
	public int nok(int firstNumber, int secondNumber) {
		return (firstNumber * secondNumber) / nod(firstNumber, secondNumber);
	}
}
