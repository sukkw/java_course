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

		try {
			reader.read();
		} catch (NumberFormatException e) {
			System.out.println("Invalid format");
		} catch (OutOfBoundException e) {
			System.out.println("Value is out of range!");
		}catch (Exception e) {
			System.out.println("Error in value....");
		}
	}
}
