package com.sirma.itt.javacourse.exceptions;

/**
 * ConsoleReader run class.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleReaderRun {

	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ConsoleReader reader = new ConsoleReader();

		String enteredValue = reader.read();

		System.out.println("Chisloto koeto vuvedohte e: " + enteredValue);
	}
}
