package com.sirma.itt.javacourse.exceptions;

import java.util.Scanner;

/**
 * Elements list run class.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class ElementsListArrayRun {

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Object[] elements = new Object[5];
		ElementsListArray elList = new ElementsListArray(elements);

		boolean checker = true;
		do {
			Scanner input = new Scanner(System.in);
			String str;
			System.out.print("A(dd) / D(elete) / E(xit)");
			str = input.next();

			switch (str) {

				case "A":
					try {
						elList.add("test");
						elList.printAllElements();
					} catch (ListException e) {
						e.printStackTrace();
					}
					break;
				case "D":
					try {
						elList.remove();
						elList.printAllElements();
					} catch (ListException e) {
						e.printStackTrace();
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