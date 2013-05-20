package com.sirma.itt.javacourse.command;

public interface CalculatorTmpl {
	
	public int add(int firstNumber, int secondNumber);
	public int subtract(int firstNumber, int secondNumber);
	public int multiply(int firstNumber, int secondNumber);
	public int divide(int firstNumber, int secondNumber);
	public int pow(int firstNumber, int secondNumber);
	public void print();
	
}
