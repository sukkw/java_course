package com.sirma.itt.javacourse.command;

public class Pow implements Command {

	CalculatorTmpl calculator;
	int firstNumber;
	int secondNumber;
	
	public Pow(CalculatorTmpl calculator, int firstNumber, int secondNumber){
		this.calculator = calculator;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	public void execute() {
		calculator.pow(firstNumber, secondNumber);
		calculator.print();
	}
}
