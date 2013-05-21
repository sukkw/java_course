package com.sirma.itt.javacourse.command;

/**
 * Find the sum of two integer numbers. Implements Command interface.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Add implements Command {

	// class private members
	private CalculatorTmpl calculator;
	private int firstNumber;
	private int secondNumber;
	
	/**
	 * Constructor.
	 * @param calculator - calculator object
	 * @param firstNumber - first operand
	 * @param secondNumber - second operand
	 */
	public Add(CalculatorTmpl calculator, int firstNumber, int secondNumber){
		this.calculator = calculator;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	/**
	 * Call calculator method add to find the sum of two numbers.
	 */
	public void execute() {
		calculator.add(firstNumber, secondNumber);
		calculator.print();
	}
}
