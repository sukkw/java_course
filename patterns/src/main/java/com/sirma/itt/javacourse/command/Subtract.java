package com.sirma.itt.javacourse.command;

public class Subtract implements Command {

	CalculatorTmpl calculator;
	
	public Subtract(CalculatorTmpl calculator){
		this.calculator = calculator;
	}
	
	public void execute(int firstNumber, int secondNumber) {
		calculator.subtract(firstNumber, secondNumber);
	}
}
