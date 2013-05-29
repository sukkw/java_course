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
	private Hashtable<String, Vector<TV>> inStock;
	
	/**
	 * Constructor. Register observer.
	 */
	public TVStore() {
		this.addObserver(new TVObserver());
		inStock = new Hashtable<String, Vector<TV>>();
	}
	
	/**
	 * Add new product in the store and notifies the observer.
	 * @param model	product id.
	 * @param tv  product.
	 */
	public void add(String mark) {
		if(inStock.containsKey(mark)) {
			Vector<TV> v = inStock.get(mark);
			v.addElement(new TV(mark));
		} else {
			Vector<TV> v = new Vector<TV>();
			v.addElement(new TV(mark));
			inStock.put(mark, v);
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
			Vector<TV> pieces = inStock.get(mark);
			sold = pieces.remove(pieces.size()-1);
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
		Vector<TV> pieces;
		for (Enumeration<String> e = inStock.keys(); e.hasMoreElements();) {
			String id = e.nextElement();
			pieces = inStock.get(id);
			System.out.println(" TV " + id + " pices " + pieces.size());
		}
	}
}
