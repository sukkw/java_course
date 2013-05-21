package com.sirma.itt.javacourse.proxy;

import java.math.BigInteger;

/**
 * Integer proxy class.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class IntegerProxy implements IntegerTmpl {

	// class private members
	private Integer integer;
	private int result;
	
	/**
	 * Constructor. Get instance of Integer class.
	 */
	public IntegerProxy () {
		integer = new Integer();
	}
	
	/**
	 * Adds two integers using Integer class object.
	 */
	public int add(int firstNumber, int secondNumber) {
		result = integer.add(firstNumber, secondNumber);
		return result;
	}
	
	/**
	 * Subtracts two integers using Integer class object.
	 */
	public int subtract(int firstNumber, int secondNumber) {
		result = integer.subtract(firstNumber, secondNumber);
		return result;
	}

	/**
	 * Multiplies two integers using Integer class object.
	 */
	public int multy(int firstNumber, int secondNumber) {
		result = integer.multy(firstNumber, secondNumber);
		return result;
	}
	
	/**
	 * Divide two integers using Integer class object.
	 */
	public int divide(int firstNumber, int secondNumber) {
		result = integer.divide(firstNumber, secondNumber);
		return result;
	}
	
	/**
	 * Invokes print method from the original class Integer.
	 */
	public void print() {
		integer.print();
	}

}
