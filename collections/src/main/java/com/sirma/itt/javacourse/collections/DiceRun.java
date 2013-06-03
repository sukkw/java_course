package com.sirma.itt.javacourse.collections;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.io.ConsoleReader;

/**
 * Dice run class .Prints statistics for chosen combination it exists.
 * 
 * @version 1.1 09 May 2013
 * @author Stella Djulgerova
 */
public class DiceRun {

	/**
	 * Class main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Dice dices = new Dice();
		dices.throwDices();
		int firstDice = 0;
		int secondDice = 0;
		List<Integer> positionsList = new ArrayList<Integer>();

		// user is asked to enter valid combination
		do {
			try {
				System.out.println("First  dice : ");
				firstDice = ConsoleReader.readInt();
				System.out.println("Second dice : ");
				secondDice = ConsoleReader.readInt();
			} catch (NumberFormatException e) {
				System.out.println("Invalid integer format");
			}
		} while (firstDice < 1 || firstDice > 6 || secondDice < 1
				|| secondDice > 6);

		String combinationKey = firstDice + "," + secondDice + " " + secondDice
				+ "," + firstDice;

		// search in hash table for given combination and print result
		if (((positionsList = dices.getCombination(combinationKey)) != null)) {
			System.out.println("combination (" + firstDice + "," + secondDice
					+ ") thrown at positions " + positionsList);
			System.out.println("number of rolls : " + positionsList.size());

		} else {
			System.out.println("There is no such combination in statistics!");
		}
	}
}
