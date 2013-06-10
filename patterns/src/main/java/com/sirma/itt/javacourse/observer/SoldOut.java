package com.sirma.itt.javacourse.observer;

import java.util.Hashtable;

/**
 * Keep information about all sold out TVs
 * 
 * @version 1.1 22 May 2013
 * @author Stella Djulgerova
 */
public class SoldOut {

	// class private members
	private Hashtable<String, TV> soldOut;
	
	/**
	 * Constructor
	 */
	public SoldOut() {
		soldOut = new Hashtable<String, TV>();
	}

	/**
	 * Add the sold TV in the list of all sold TVs.
	 * 
	 * @param soldTV - The sold tv.
	 */
	public void add(TV soldTV) {
		String mark = soldTV.getMark();
		soldOut.put(mark, soldTV);
	}

	/**
	 * Remove TV from list with unavailable products.
	 * @param soldTV
	 */
	public void remove(String suppliedTV) {
		if (soldOut.containsKey(suppliedTV)) {
			soldOut.remove(suppliedTV);
			System.out.println("Model " + suppliedTV + " in Stock again!");
		}
	}
}