package com.sirma.itt.javacourse.command;

/**
 * Calculator interface. Defines different math operations.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public interface CalculatorTmpl {
	
	public int add(int firstNumber, int secondNumber);
	public int subtract(int firstNumber, int secondNumber);
	public int multiply(int firstNumber, int secondNumber);
	public int divide(int firstNumber, int secondNumber);
	public int pow(int firstNumber, int secondNumber);
	public void print();
	
}
