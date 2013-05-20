package com.sirma.itt.javacourse.command;

public class Calculator implements CalculatorTmpl {

	private int result;
	
	public int add(int firstNumber, int secondNumber) {
		result = firstNumber + secondNumber;
		return result;
	}

	public int subtract(int firstNumber, int secondNumber) {
		result = firstNumber - secondNumber;
		return result;
	}

	public int multiply(int firstNumber, int secondNumber) {
		result = firstNumber * secondNumber;
		return result;
	}

	public int divide(int firstNumber, int secondNumber) {
		result = firstNumber / secondNumber;
		return 0;
	}

	public int pow(int firstNumber, int secondNumber) {
		result = firstNumber ^ secondNumber;
		return result;
	}
	
	public void print() {
		System.out.println("Result: " + result);
	}
}
