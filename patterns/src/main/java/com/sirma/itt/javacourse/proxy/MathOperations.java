package com.sirma.itt.javacourse.proxy;

/**
 * Interface with all methods mandatory for Integer class.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public interface MathOperations {

	int add(int firstNumber, int secondNumber);
	int subtract(int firstNumber, int secondNumber);
	int multy(int firstNumber, int secondNumber);
	int divide(int firstNumber, int secondNumber);
    
	void print();

}
