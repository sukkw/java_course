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
	private Hashtable<String, List<Integer>> statisticTable = new Hashtable<String, List<Integer>>();

	/**
	 * Throw dices. Generate hashTable key from thrown combinations and
	 * save the combination and the position of combination
	 */
	public void throwDices(int numberOfThrows) {
		
		int firstDice = 0;
		int secondDice = 0;
		String combinationKey;
		List<Integer> positionsList = new ArrayList<Integer>();

		for (int i = 0; i < numberOfThrows; i++) {

			firstDice = 1 + (int) (Math.random() * 6);
			secondDice = 1 + (int) (Math.random() * 6);
			
			// combination of two dices
			combinationKey = firstDice + "," + secondDice + " " + secondDice + "," + firstDice;

			if (statisticTable.containsKey(combinationKey)) {
				positionsList = statisticTable.get(combinationKey);
			} else {
				List<Integer> positionList = new ArrayList<Integer>();
			}
			
			positionsList.add(i);
			statisticTable.put(combinationKey, positionsList);
		}
	}

	/**
	 * Get combination from hashTable
	 * @param combinationKey - key to be searched for
	 * @return - list with positions
	 */
	public List<Integer> getCombination(String combinationKey) {
		if(combinationKey == null) {
			return null;
		}
		return statisticTable.get(combinationKey);
	}
}
