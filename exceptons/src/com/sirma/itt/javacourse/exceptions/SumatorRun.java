package com.sirma.itt.javacourse.exceptions;

/**
 * Sumator run class
 * 
 * @version 1.1 20 April 2013
 * @author Stella Djulgerova
 */
public class SumatorRun {

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Sumator sumator = new Sumator();

		String firstNumber = sumator.read();
		String secondNumber = sumator.read();
		
		System.out.println("Sbora na chislata e: " + sumator.calculate(firstNumber, secondNumber));
	}
}
