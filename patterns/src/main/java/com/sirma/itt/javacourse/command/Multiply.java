package com.sirma.itt.javacourse.command;

/**
 * Multiply two integer numbers. Implements Command interface.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Multiply implements Command {

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
	public Multiply(CalculatorTmpl calculator, int firstNumber, int secondNumber){
		this.calculator = calculator;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	/**
	 * Call calculator method multiply.
	 */
	public void execute() {
		calculator.multiply(firstNumber, secondNumber);
		calculator.print();
	}
}
