package com.sirma.itt.javacourse.collections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Two dices are thrown. 
 * All different combinations are saved in hashTable and statistic is built.
 * 
 * @version 1.1 09 May 2013
 * @author Stella Djulgerova
 */
public class Dice {

	// class private members
	private final int NUMBER_OF_THROWS = 100;
	private Hashtable<String, List<Integer>> statisticTable = new Hashtable<String, List<Integer>>();

	/**
	 * Throw dices. Generate hashTable key from thrown combinations and
	 * save the combination and the position of combination
	 */
	public void throwDices() {
		
		int firstDice = 0;
		int secondDice = 0;
		String combinationKey;
		List<Integer> positionsList = new ArrayList<Integer>();

		for (int i = 0; i < NUMBER_OF_THROWS; i++) {

			firstDice = 1 + (int) (Math.random() * 6);
			secondDice = 1 + (int) (Math.random() * 6);
			
			// combination of two dices
			combinationKey = firstDice + "," + secondDice + " " + secondDice + "," + firstDice;

			if (statisticTable.containsKey(combinationKey)) {
				positionsList = statisticTable.get(combinationKey);
				positionsList.add(i);
				statisticTable.put(combinationKey, positionsList);
			} else {
				List<Integer> positionList = new ArrayList<Integer>();
				positionList.add(i);
				statisticTable.put(combinationKey, positionList);
			}
		}
	}

	/**
	 * Get combination from hashTable
	 * @param combinationKey - key to be searched for
	 * @return - list with positions
	 */
	public List<Integer> getCombination(String combinationKey) {
		return statisticTable.get(combinationKey);
	}
}
