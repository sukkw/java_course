package com.sirma.itt.javacourse.exceptions;

/**
 * Sumator run class.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class SumatorRun {

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Sumator sumator = new Sumator();

		String firstNumber = sumator.read();
		String secondNumber = sumator.read();

		try {
			System.out.println("Sum of numbers is: "
					+ sumator.calculate(firstNumber, secondNumber));
		} catch (NumberFormatException e) {
			System.out.println("Invalid format. Please enter only digits");
		}
	}
}
