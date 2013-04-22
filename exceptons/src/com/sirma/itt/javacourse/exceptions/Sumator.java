package com.sirma.itt.javacourse.exceptions;

import java.util.Scanner;
import com.sirma.itt.javacourse.intro.SumOfStrings;

/**
 * Calculate sum of two numbers when present the digits as string.
 * 
 * @version 1.1 20 April 2013
 * @author Stella Djulgerova
 */
public class Sumator {

	/**
	 * Check entered string for valid data.
	 * 
	 * @param str
	 * @return
	 */
	public String validate(String str) {
		boolean checker = true;
		do {
			try {
				for (int i = 0; i < str.length(); i++) {
					Integer.parseInt(str.charAt(i) + "");
				}
				checker = false;
			} catch (NumberFormatException e) {
				System.out.println("Chisloto koeto ste vuveli ne e sustaveno ot cifri!");
				Scanner input = new Scanner(System.in);
				str = read();
			}
		} while (checker);
		return str;
	}

	/**
	 * Read string from console.
	 * 
	 * @return
	 */
	public String read() {

		String str;

		Scanner input = new Scanner(System.in);

		System.out.print("Vuvedete chislo : ");
		str = input.next();

		return validate(str);
	}

	/**
	 * Calculate value of two strings as number.
	 * 
	 * @param firstString
	 * @param secondString
	 * @return sum of firstString and secondString
	 */
	public String calculate(String firstString, String secondString) {
		SumOfStrings sum = new SumOfStrings();
		return sum.calculate(firstString, secondString);
	}
}
