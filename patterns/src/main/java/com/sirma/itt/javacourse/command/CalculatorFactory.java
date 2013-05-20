package com.sirma.itt.javacourse.command;

public class CalculatorFactory {
	public static CalculatorTmpl getCalculator(){
		
		return new Calculator();
		
	}
}
