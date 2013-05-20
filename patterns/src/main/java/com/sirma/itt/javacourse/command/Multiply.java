package com.sirma.itt.javacourse.command;

public class Multiply implements Command {

	CalculatorTmpl calculator;
	
	public Multiply(CalculatorTmpl calculator){
		this.calculator = calculator;
	}
	
	public void execute(int firstNumber, int secondNumber) {
		calculator.multiply(firstNumber, secondNumber);
	}
}
