package com.sirma.itt.javacourse.io;

import java.util.Scanner;

/**
 * Read different types from console.
 * 
 * @version 1.1 30 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleReader {

	/**
	 * Make private constructor don't allow instance to be made
	 */
	private ConsoleReader() {

	}

	/**
	 * Read string from console
	 * @param enteredValue - string entered by user
	 * @return string entered by user
	 */
	private static String readString(String enteredValue) {
		System.out.println(enteredValue);
		return enteredValue;

	}

	/**
	 * Read integer from console
	 * @param enteredValue - string entered by user
	 * @return - string entered by user converted in int
	 */
	private static int readInt(String enteredValue) {
		int intValue = 0;
		try {
			intValue = Integer.parseInt(enteredValue);
			System.out.println(intValue);
		} catch (NumberFormatException e) {
			System.out.println("Invalid integer format");
		}
		return intValue;
	}

	/**
	 * Read char from console
	 * @param enteredValue
	 * @return
	 */
	private static char readChar(String enteredValue) {
		char charValue = 0;
		if (enteredValue.length() == 1) {
			charValue = enteredValue.charAt(0);
			System.out.println(charValue);

		} else {
			System.out.println("Invalid char format");
		}
		return charValue;
	}

	/**
	 * Read float from console
	 * @param enteredValue - string entered by user
	 * @return - string entered by user converted in float
	 */
	private static float readFloat(String enteredValue) {
		float floatValue = 0;
		try {
			floatValue = Float.parseFloat(enteredValue);
			System.out.println(floatValue);
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
			Scanner input = new Scanner(System.in);
			String enteredValue;
			System.out.println("S(tring) / I(nteger) / C(har) / F(loat) / E(xit)");
			enteredValue = input.nextLine();

			switch (enteredValue) {

			case "S":
				System.out.println("Enter string: ");
				enteredValue = input.nextLine();
				readString(enteredValue);
				break;
			case "I":
				System.out.println("Enter integer value: ");
				enteredValue = input.next();
				readInt(enteredValue);
				break;
			case "C":
				System.out.println("Enter char: ");
				enteredValue = input.next();
				readChar(enteredValue);
				break;
			case "F":
				System.out.println("Enter double value: ");
				enteredValue = input.next();
				readFloat(enteredValue);
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
