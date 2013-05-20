package com.sirma.itt.javacourse.command;

public class Divide implements Command {

	CalculatorTmpl calculator;
	
	public Divide(CalculatorTmpl calculator){
		this.calculator = calculator;
	}
	
	public void execute(int firstNumber, int secondNumber) {
		calculator.divide(firstNumber, secondNumber);
	}
}
