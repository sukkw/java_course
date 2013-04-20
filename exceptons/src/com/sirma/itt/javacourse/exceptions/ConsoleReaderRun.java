package com.sirma.itt.javacourse.exceptions;

/**
 * ConsoleReader run class
 * 
 * @version 1.1 20 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleReaderRun {

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ConsoleReader reader = new ConsoleReader();

		String enteredValue = reader.read();

		System.out.println("Chisloto koeto vuvedohte e: " + Integer.parseInt(enteredValue));
	}
}
