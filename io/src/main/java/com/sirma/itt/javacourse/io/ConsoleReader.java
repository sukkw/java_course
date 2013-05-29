package com.sirma.itt.javacourse.io;

import java.util.NoSuchElementException;
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
		String enteredString = input();
		return enteredString;
	}

	/**
	 * Read integer from console.
	 * @return - string entered by user converted to integer
	 */
	public static int readInt() throws NumberFormatException {
		return Integer.parseInt(input());
	}

	/**
	 * Read char from console.
	 * @return - char entered by user
	 */
	public static char readChar() {
		
		String enteredString = input();
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
	public static float readFloat() throws NumberFormatException {
		return Float.parseFloat(input());
	}
	
	/**
	 * Read information from console.
	 * @return entered line
	 */
	public static String input() {
		
		String s = null;
		try {
			s = input.next();
		} catch(NoSuchElementException e) {
			System.out.println("Scanner is closed !!");
			System.exit(0);
		}
		return s;
	}
}
