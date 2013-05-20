package com.sirma.itt.javacourse.command;

public class Divide implements Command {

	CalculatorTmpl calculator;
	int firstNumber;
	int secondNumber;
	
	public Divide(CalculatorTmpl calculator, int firstNumber, int secondNumber){
		this.calculator = calculator;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	public void execute() {
		calculator.divide(firstNumber, secondNumber);
		calculator.print();
	}
}
