package com.sirma.itt.javacourse.observer;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Vector;

/**
 * TV store class. Add new product in store. 
 * Remove product if it's sold out and print all
 * available for sell products.
 * 
 * @version 1.1 22 May 2013
 * @author Stella Djulgerova
 */
public class TVStore extends Observable {

	// class private members
	private Hashtable inStock;
	
	/**
	 * Constructor. Register observer.
	 */
	public TVStore() {
		this.addObserver(new TVObserver());
		inStock = new Hashtable();
	}
	
	/**
	 * Add new product in the store and notifies the observer.
	 * @param model	product id.
	 * @param tv  product.
	 */
	public void add(String mark, TV tv) {
		if(inStock.containsKey(mark)) {
			Vector v = (Vector)inStock.get(mark);
			v.addElement(tv);
		} else {
			Vector pieces = new Vector();
			pieces.addElement(tv);
			inStock.put(mark, pieces);
		}
		setChanged();
		notifyObservers(mark);
	}
	
	/**
	 * Sell product and notifies the observer.
	 * @param model product id.
	 */
	public void sell(String mark) {
		TV sold = null;
		if(inStock.containsKey(mark)) {
			Vector pieces = (Vector) inStock.get(mark);
			sold = (TV) pieces.remove(pieces.size()-1);
			System.out.println("Sold TV " + sold.getMark());
			if(pieces.isEmpty())	
				inStock.remove(mark);
			setChanged();
			notifyObservers(sold);
		} else {
			System.out.println("TV " + mark + " is out of order!");
		}
	}
	
	/**
	 * Prints out the availability of the store.
	 */
	public void showStock() {
		Vector pieces;
		for (Enumeration e = inStock.keys(); e.hasMoreElements();) {
			String id = (String) e.nextElement();
			pieces = (Vector) inStock.get(id);
			System.out.println(" TV " + id + " pices " + pieces.size());
		}
	}
}
