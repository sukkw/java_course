package com.sirma.itt.javacourse.observer;

import java.util.Scanner;

public class ObserverRun {

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
				System.out.println("Model: ");
				store.add(input.nextLine(), new TV(input.nextLine()));
				break;
			case "2":
				System.out.println("Model: ");
				store.sell(input.nextLine());
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
