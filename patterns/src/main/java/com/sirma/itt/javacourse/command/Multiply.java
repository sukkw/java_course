package com.sirma.itt.javacourse.command;

public class Multiply implements Command {

	CalculatorTmpl calculator;
	int firstNumber;
	int secondNumber;
	
	public Multiply(CalculatorTmpl calculator, int firstNumber, int secondNumber){
		this.calculator = calculator;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	public void execute() {
		calculator.multiply(firstNumber, secondNumber);
		calculator.print();
	}
}
