package com.sirma.itt.javacourse.exceptions;

import java.util.Scanner;

/**
 * Read numbers from console. Only from 0 to 100
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleReader {

	/**
	 * Read numbers between 0 and 100 from console. If number is not
	 * in range throws OutOfBoundException
	 * 
	 * @return - entered value
	 * @throws NumberFormatException
	 * @throws OutOfBoundException
	 */
	public String read() throws NumberFormatException, OutOfBoundException {
		String enteredStr;
		String repeat = "y";
		int strToInt;
		Scanner input = new Scanner(System.in);

		do {

			System.out.print("Enter number from 0 to 100: ");
			enteredStr = input.next();
			strToInt = Integer.parseInt(enteredStr);

			if (strToInt < 0 || strToInt > 100) {
				throw new OutOfBoundException("Value is out of range!");
			}

			System.out.println("Continue (y/n) ?");
			repeat = input.next();
		} while (!"n".equals(repeat));

		return enteredStr;
	}
}
