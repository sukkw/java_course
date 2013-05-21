package com.sirma.itt.javacourse.command;

/**
 * Divide two integer numbers. Implements Command interface.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Divide implements Command {

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
	public Divide(CalculatorTmpl calculator, int firstNumber, int secondNumber){
		this.calculator = calculator;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	/**
	 * Call calculator method divide.
	 */
	public void execute() {
		calculator.divide(firstNumber, secondNumber);
		calculator.print();
	}
}
