package com.sirma.itt.javacourse.command;

public class Subtract implements Command {

	CalculatorTmpl calculator;
	int firstNumber;
	int secondNumber;
	
	public Subtract(CalculatorTmpl calculator, int firstNumber, int secondNumber){
		this.calculator = calculator;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	public void execute() {
		calculator.subtract(firstNumber, secondNumber);
		calculator.print();
	}
}
