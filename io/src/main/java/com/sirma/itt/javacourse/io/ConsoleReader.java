package com.sirma.itt.javacourse.io;

import java.util.Scanner;

/**
 * Read different types from console.
 * 
 * @version 1.1 30 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleReader {

	private static Scanner input = new Scanner(System.in);
	
	/**
	 * Make private constructor don't allow instance to be made.
	 */
	private ConsoleReader() {

	}

	/**
	 * Read string from console.
	 * @return string entered by user
	 */
	public static String readString() {
		System.out.println("Enter string: ");
		String enteredString = input.next();
		return enteredString;
	}

	/**
	 * Read integer from console.
	 * @return - string entered by user converted to integer
	 */
	public static int readInt() {
		
		System.out.println("Enter integer value: ");
		int intValue = 0;
		
		try {
			intValue = Integer.parseInt(input.next());
		} catch (NumberFormatException e) {
			System.out.println("Invalid integer format");
		}
		return intValue;
	}

	/**
	 * Read char from console.
	 * @return - char entered by user
	 */
	public static char readChar() {
		
		System.out.println("Enter char: ");
		String enteredString = input.next();
		char enteredChar = 0;
		
		if (enteredString.length() == 1) {
			enteredChar = enteredString.charAt(0);
		} else {
			System.out.println("Invalid char format");
		}
		return enteredChar;
	}

	/**
	 * Read float from console.
	 * @return - string entered by user converted in float
	 */
	public static float readFloat() {
		System.out.println("Enter double value: ");
		
		float floatValue = 0;
		try {
			floatValue = Float.parseFloat(input.next());
		} catch (NumberFormatException e) {
			System.out.println("Invalid float format");
		}
		return floatValue;
	}

	/**
	 * Read string from console and do action.
	 */
	public static void read() {
		boolean checker = true;
		do {
			String enteredValue;
			System.out.println("S(tring) / I(nteger) / C(har) / F(loat) / E(xit)");
			enteredValue = input.next();

			switch (enteredValue) {

			case "S":
				System.out.println("You entered: " + readString());
				break;
			case "I":
				System.out.println("You entered: " + readInt());
				break;
			case "C":
				System.out.println("You entered: " + readChar());
				break;
			case "F":
				System.out.println("You entered: " + readFloat());
				break;
			case "E":
				checker = false;
				break;
			default:
				break;
			}
		} while (checker);
	}
}
