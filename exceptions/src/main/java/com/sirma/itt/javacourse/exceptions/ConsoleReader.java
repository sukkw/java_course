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
	 * Check entered string for valid data.
	 * 
	 * @param str - string to be validate
	 * @return string with number in correct interval
	 */
	public String validate(String str) {
		boolean checker = false;
		do {
			try {
				for (int i = 0; i < str.length(); i++) {
					Integer.parseInt(str.charAt(i) + "");
				}
				outOfBoundCheck(str);
				checker = true;
			} catch (IllegalArgumentException e) {
				System.out.println("Nevalidna stojnost!");
				Scanner input = new Scanner(System.in);
				str = read();
			} catch (OutOfBoundException e) {
				System.out.println(e.getError());
				Scanner input = new Scanner(System.in);
				str = read();
			}
		} while (!checker);

		return str;
	}

	/**
	 * Check if number is between 0 and 100.
	 * 
	 * @param str - string to be checked
	 * @throws OutOfBoundException - custom exception. Throw if number is less than 0 or bigger than 100
	 */
	public void outOfBoundCheck(String str) throws OutOfBoundException {
		if (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 100) {
			throw new OutOfBoundException("Nevalidna stojnost!");
		}

	}

	/**
	 * Read string from console.
	 * 
	 * @return entered string
	 */
	public String read() {

		String str;
		Scanner input = new Scanner(System.in);

		System.out.print("Vuvedete chislo ot 0 do 100: ");
		str = input.next();

		return validate(str);
	}
}
