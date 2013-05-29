package com.sirma.itt.javacourse.command;

/**
 * Find the sum of two integer numbers. Implements Command interface.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Add implements Command {

	// class private members
	private int firstNumber;
	private int secondNumber;
	
	/**
	 * Constructor.
	 * @param firstNumber - first operand
	 * @param secondNumber - second operand
	 */
	public Add(int firstNumber, int secondNumber){
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	/**
	 * Call calculator method add to find the sum of two numbers.
	 */
	public void execute() {
		System.out.println("Result: " + (firstNumber + secondNumber));
	}
}
