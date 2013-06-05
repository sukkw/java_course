package com.sirma.itt.javacourse.exceptions;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Elements list run class.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class ElementsListRun {

	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ElementsList list = new ElementsList();
		boolean checker = true;

		do {
			Scanner input = new Scanner(System.in);
			String str;
			System.out.print("A(dd) / D(elete) / E(xit)");
			str = input.next();

			switch (str) {

			case "A":
				try {
					list.add("test");
					list.printAllElements();
				} catch (ListException e) {
					System.out.println("You can't add more elements!");
				}
				break;

			case "D":
				try {
					list.remove();
					list.printAllElements();
				} catch (EmptyStackException e) {
					System.out.println("You can't remove from empty list!");
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