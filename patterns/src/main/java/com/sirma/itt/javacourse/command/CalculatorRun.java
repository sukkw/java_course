package com.sirma.itt.javacourse.command;

public class CalculatorRun {

	public static void main(String[] args) {
		
		CalculatorTmpl calculator = new Calculator();
		Add add = new Add(calculator, 2, 3);
		add.execute();
		
	}
}
