package com.sirma.itt.javacourse.observer;

import java.util.Hashtable;

public class SoldOut {

	private Hashtable<String, TV> soldOut;
	
	public SoldOut() {
		soldOut = new Hashtable<String, TV>();
	}

	/**
	 * Add the sold TV in the list of all sold goods.
	 * 
	 * @param soldTV - The sold tv.
	 */
	public void add(TV soldTV) {
		String id = "" + soldTV.hashCode();
		soldOut.put(id, soldTV);
	}

	public void remove(String soldTV) {
		if (soldOut.containsKey(soldTV)) {
			soldOut.remove(soldTV);
			System.out.println("Model " + soldTV + " in Stock again!");
		}
	}

}
