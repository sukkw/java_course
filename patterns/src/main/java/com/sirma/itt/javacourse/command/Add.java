package com.sirma.itt.javacourse.command;

public class Add implements Command {

	CalculatorTmpl calculator;
	
	public Add(CalculatorTmpl calculator){
		this.calculator = calculator;
	}
	
	public void execute(int firstNumber, int secondNumber) {
		calculator.add(firstNumber, secondNumber);
	}

}
