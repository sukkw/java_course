package com.sirma.itt.javacourse.command;

/**
 * Graduate two integer numbers. Implements Command interface.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Pow implements Command {

	// class private members
	int firstNumber;
	int secondNumber;
	
	/**
	 * Constructor.
	 * @param firstNumber - first operand
	 * @param secondNumber - second operand
	 */
	public Pow(int firstNumber, int secondNumber){
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	/**
	 * Call calculator method pow.
	 */
	public void execute() {
		System.out.println("Result: " + Math.pow(firstNumber, secondNumber));
	}
}
