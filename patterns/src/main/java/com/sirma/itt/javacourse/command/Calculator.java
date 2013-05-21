package com.sirma.itt.javacourse.command;

import java.util.Scanner;

/**
 * Calculator run class.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Calculator {
	
	// class private members
	private CalculatorInvoker invoker;
	private Scanner in;
	private int firstNumber;
	private int secondNumber;
	private CalculatorTmpl calculator;
	private char operator;
	
	/**
	 * Constructor.
	 */
	public Calculator() {
		in = new Scanner(System.in);
		invoker = new CalculatorInvoker();
		calculator = new CalculatorReciver();
	}
	
	/**
	 * Reads from the console.
	 */
	public void console() {
		String ch = null;
	
		try {
			while(!"y".equals(ch)) {
				System.out.println("First number: ");
					firstNumber = Integer.parseInt(in.nextLine());
				System.out.println(" + - * / ^ ");
					operator = (in.nextLine()).charAt(0);
				System.out.println("Second number: ");
					secondNumber = Integer.parseInt(in.nextLine());
				callCommand();
				System.out.println("Do you want to quit?  (y/n) ");
					ch = in.nextLine();
			}
		} catch (NumberFormatException e) {
			System.out.println("Wrong data format!");
			console();
		} catch (Exception e) {
			System.out.println("Unexpected error! Please try again.");
			console();
		}
	}
	
	/**
	 * Execute the requested operation.
	 */
	private void callCommand() {
		switch (operator) {
		case '+' : 
			invoker.calculate(new Add(calculator, firstNumber, secondNumber));
			break;
		case '-' :
			invoker.calculate(new Subtract(calculator, firstNumber, secondNumber));
			break;
		case '*' :
			invoker.calculate(new Multiply(calculator, firstNumber, secondNumber));
			break;
		case '/' :
			invoker.calculate(new Divide(calculator, firstNumber, secondNumber));
			break;
		case '^' :
			invoker.calculate(new Pow(calculator, firstNumber, secondNumber));
			break;
		default : System.out.println("Wrong operator!");
		}
	}

}
