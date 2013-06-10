package com.sirma.itt.javacourse.proxy;

/**
 * Original Integer class.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Integer implements MathOperations {

	private int result;

	/**
	 * Add two Integers.
	 */
	public int add(int firstNumber, int secondNumber) {
		result = firstNumber + secondNumber;
		return result;
	}

	/**
	 * Subtracts two Integers.
	 */
	public int subtract(int firstNumber, int secondNumber) {
		result = firstNumber - secondNumber;
		return result;
	}

	/**
	 * Multiplies two Integers.
	 */
	public int multy(int firstNumber, int secondNumber) {
		result = firstNumber * secondNumber;
		return result;
	}
	
	/**
	 * Multiplies two Integers.
	 */
	public int divide(int firstNumber, int secondNumber) {
		result = firstNumber / secondNumber;
		return result;
	}

	/**
	 * Prints out the result of operation.
	 */
	public void print() {
		System.out.println("Result : " + result);
	}

}
