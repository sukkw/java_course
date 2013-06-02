package com.sirma.itt.javacourse.observer;

import java.util.Scanner;

/**
 * Observer design pattern run class.
 * 
 * @version 1.1 22 May 2013
 * @author Stella Djulgerova
 */
public class TVObserverRun {

	/**
	 * Class main method.
	 */
	public static void main(String[] args) {

		// creating the store
		TVStore store = new TVStore();
	
		String ch = null;
		String mark;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println(" 1-Supply / 2-Sell / 3-Print / 4-Exit");
			ch = input.nextLine();

			switch (ch) {

			case "1":
				System.out.println("Mark: ");
				mark = input.nextLine();
				store.add(mark);
				break;
			case "2":
				System.out.println("Mark: ");
				mark = input.nextLine();
				store.sell(mark);
				break;
			case "3":
				store.showStock();
				break;
			default:
				break;
			}

		} while (!"4".equals(ch));
	}
}
