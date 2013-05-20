package com.sirma.itt.javacourse.command;

public class Add implements Command {

	CalculatorTmpl calculator;
	int firstNumber;
	int secondNumber;
	
	public Add(CalculatorTmpl calculator, int firstNumber, int secondNumber){
		this.calculator = calculator;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	public void execute() {
		calculator.add(firstNumber, secondNumber);
		calculator.print();
	}
}
