package com.sirma.itt.javacourse.command;

/**
 * Multiply two integer numbers. Implements Command interface.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Multiply implements Command {

	// class private members
	int firstNumber;
	int secondNumber;
	
	/**
	 * Constructor.
	 * @param firstNumber - first operand
	 * @param secondNumber - second operand
	 */
	public Multiply(int firstNumber, int secondNumber){
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	/**
	 * Call calculator method multiply.
	 */
	public void execute() {
		System.out.println("Result: " + (firstNumber * secondNumber));
	}
}
