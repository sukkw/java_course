package com.sirma.itt.javacourse.command;

/**
 * Execute different math operations. Implements CalculatorTmpl interface.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class CalculatorReciver implements CalculatorTmpl {

	// result of operations
	private int result;

	/**
	 * Find the sum of two integer numbers.
	 * 
	 * @param firstNumber - first operand
	 * @param secondNumber - second operand
	 * @return - result after sum
	 */
	public int add(int firstNumber, int secondNumber) {
		result = firstNumber + secondNumber;
		return result;
	}

	/**
	 * Subtract two integer numbers.
	 * 
	 * @param firstNumber - first operand
	 * @param secondNumber - second operand
	 * @return - result after subtraction
	 */
	public int subtract(int firstNumber, int secondNumber) {
		result = firstNumber - secondNumber;
		return result;
	}

	/**
	 * Multiply two integer numbers.
	 * 
	 * @param firstNumber - first operand
	 * @param secondNumber - second operand
	 * @return - result after multiplication
	 */
	public int multiply(int firstNumber, int secondNumber) {
		result = firstNumber * secondNumber;
		return result;
	}

	/**
	 * Divide two integer numbers.
	 * 
	 * @param firstNumber - first operand
	 * @param secondNumber - second operand
	 * @return - result after division
	 */
	public int divide(int firstNumber, int secondNumber) {
		result = firstNumber / secondNumber;
		return 0;
	}

	/**
	 * Graduate two integer numbers.
	 * 
	 * @param firstNumber - first operand
	 * @param secondNumber - second operand
	 * @return - result after graduation
	 */
	public int pow(int firstNumber, int secondNumber) {
		result = (int) Math.pow(firstNumber,secondNumber);
		return result;
	}

	/**
	 * Print result of each operation
	 */
	public void print() {
		System.out.println("Result: " + result);
	}
}
