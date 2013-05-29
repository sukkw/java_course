package com.sirma.itt.javacourse.io;

/**
 * ConsoleReader run class.
 * 
 * @version 1.1 30 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleReaderRun {

	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		boolean checker = true;
		do {
			String enteredValue;
			System.out.println("S(tring) / I(nteger) / C(har) / F(loat) / E(xit)");
			enteredValue = ConsoleReader.input();

			switch (enteredValue) {

			case "S":
				System.out.println("Enter string: ");
				System.out.println("You entered: " + ConsoleReader.readString());
				break;
			case "I":
				System.out.println("Enter integer value: ");
				try {
					System.out.println("You entered: " + ConsoleReader.readInt());
				} catch (NumberFormatException e) {
					System.out.println("Invalid integer format");
				}
				break;
			case "C":
				System.out.println("Enter char: ");
				System.out.println("You entered: " + ConsoleReader.readChar());
				break;
			case "F":
				System.out.println("Enter double value: ");
				try {
					System.out.println("You entered: " + ConsoleReader.readFloat());
				} catch (NumberFormatException e) {
					System.out.println("Invalid float format");
				}
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
