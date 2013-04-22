package com.sirma.itt.javacourse.exceptions;

import java.util.Scanner;

/**
 * Read numbers from console. Only from 0 to 100
 * 
 * @version 1.1 20 April 2013
 * @author Stella Djulgerova
 */
public class ConsoleReader {

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
				outOfBoundCheck(str);
				checker = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Nevalidna stojnost!");
				Scanner input = new Scanner(System.in);
				str = read();
			} catch (OutOfBoundException e) {
				System.out.println(e.getError());
				Scanner input = new Scanner(System.in);
				str = read();
			}
		} while (checker);

		return str;
	}

	/**
	 * Check if number is between 0 and 100.
	 * 
	 * @param str
	 * @throws OutOfBoundException
	 */
	public void outOfBoundCheck(String str) throws OutOfBoundException {
		if (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 100) {
			throw new OutOfBoundException("Nevalidna stojnost!");
		}

	}

	/**
	 * Read string from console.
	 * 
	 * @return
	 */
	public String read() {

		String str;

		Scanner input = new Scanner(System.in);

		System.out.print("Vuvedete chislo ot 0 do 100: ");
		str = input.next();

		return validate(str);
	}
}
