package com.sirma.itt.javacourse.command;

/**
 * Subtract two integer numbers. Implements Command interface.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Subtract implements Command {

	// class private members
	CalculatorTmpl calculator;
	int firstNumber;
	int secondNumber;
	
	/**
	 * Constructor.
	 * @param calculator - calculator object
	 * @param firstNumber - first operand
	 * @param secondNumber - second operand
	 */
	public Subtract(CalculatorTmpl calculator, int firstNumber, int secondNumber){
		this.calculator = calculator;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	/**
	 * Call calculator method subtract.
	 */
	public void execute() {
		calculator.subtract(firstNumber, secondNumber);
		calculator.print();
	}
}
