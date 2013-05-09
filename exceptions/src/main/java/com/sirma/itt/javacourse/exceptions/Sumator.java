package com.sirma.itt.javacourse.exceptions;

import java.util.Scanner;

import com.sirma.itt.javacourse.intro.SumOfStrings;

/**
 * Calculate sum of two numbers when present the digits as string.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class Sumator {

	/**
	 * Read string from console.
	 * 
	 * @return entered string
	 */
	public String read() {

		String str;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number : ");
		str = input.next();

		return str;
	}
	


	/**
	 * Calculate value of two strings as number.
	 * 
	 * @param firstString - big number
	 * @param secondString - big number to be added to firstString
	 * @return sum of firstString and secondString
	 */
	public String calculate(String firstString, String secondString) throws NumberFormatException {
		SumOfStrings sum = new SumOfStrings();
		return sum.calculate(firstString, secondString);
	}
}
