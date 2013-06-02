package com.sirma.itt.javacourse.command;

/**
 * Divide two integer numbers. Implements Command interface.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Divide implements Command {

	// class private members
	int firstNumber;
	int secondNumber;
	
	/**
	 * Constructor.
	 * @param firstNumber - first operand
	 * @param secondNumber - second operand
	 */
	public Divide(int firstNumber, int secondNumber){
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	/**
	 * Call calculator method divide.
	 */
	public void execute() {
		if(secondNumber != 0) {
			System.out.println("Result: " + (firstNumber / secondNumber));
		} else {
			System.err.println("Error: Division by zero" );
		}
	}
}
