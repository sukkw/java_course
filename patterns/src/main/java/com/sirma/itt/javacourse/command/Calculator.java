package com.sirma.itt.javacourse.command;

import java.util.Scanner;

import com.sirma.itt.javacourse.io.ConsoleReader;

/**
 * Calculator run class.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class Calculator {
	
	// class private members
	private CalculatorInvoker invoker;
	private int firstNumber;
	private int secondNumber;
	private char operator;
	
	/**
	 * Constructor.
	 */
	public Calculator() {
		invoker = new CalculatorInvoker();
	}
	
	/**
	 * Reads from the console.
	 */
	public void console() {
		String ch = null;
	
		try {
			while(!"y".equals(ch)) {
				System.out.println("First number: ");
					firstNumber = ConsoleReader.readInt();
				System.out.println(" + - * / ^ ");
					operator = ConsoleReader.readChar();
				System.out.println("Second number: ");
					secondNumber = ConsoleReader.readInt();
				callCommand();
				System.out.println("Do you want to quit?  (y/n) ");
					ch = ConsoleReader.readString();
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
			invoker.calculate(new Add(firstNumber, secondNumber));
			break;
		case '-' :
			invoker.calculate(new Subtract(firstNumber, secondNumber));
			break;
		case '*' :
			invoker.calculate(new Multiply(firstNumber, secondNumber));
			break;
		case '/' :
			invoker.calculate(new Divide(firstNumber, secondNumber));
			break;
		case '^' :
			invoker.calculate(new Pow(firstNumber, secondNumber));
			break;
		default : System.out.println("Wrong operator!");
		}
	}
}