package com.sirma.itt.javacourse.command;

public class Pow implements Command {

	CalculatorTmpl calculator;
	
	public Pow(CalculatorTmpl calculator){
		this.calculator = calculator;
	}
	
	public void execute(int firstNumber, int secondNumber) {
		calculator.pow(firstNumber, secondNumber);
	}
}
