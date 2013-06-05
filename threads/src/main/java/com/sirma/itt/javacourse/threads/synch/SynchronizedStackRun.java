package com.sirma.itt.javacourse.threads.synch;

import com.sirma.itt.javacourse.io.ConsoleReader;

/**
 * SynchronizedStack run class.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class SynchronizedStackRun {
	
	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SynchronizedStack stack = new SynchronizedStack();
		boolean checker = true;

		do {
			String str;
			System.out.println("A(dd) / D(elete) / P(rint) / E(xit)");
			str = ConsoleReader.readString();

			switch (str) {

			case "A":
				System.out.println("Enter line of text: ");
				stack.createAddThread(ConsoleReader.readString());
				break;
			case "D":
				stack.createRemoveThread();
				break;
			case "P":
				stack.printAllElements();
				break;
			case "E":
				checker = false;
				break;
			default:
				System.out.println("Wrong option. Try again");
				break;
			}
		} while (checker);
	}
}