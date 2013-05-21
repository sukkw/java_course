package com.sirma.itt.javacourse.observer;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Vector;

public class TVStore extends Observable {

	private Hashtable inStock;
	
	public TVStore() {
		this.addObserver(new StockObserver());
		inStock = new Hashtable();
	}
	
	/**
	 * Add new product in the store and notifies the observer.
	 * @param model		product id.
	 * @param tv  product.
	 */
	public void add(String model, TV tv) {
		if(inStock.containsKey(model)) {
			Vector v = (Vector)inStock.get(model);
			v.addElement(tv);
		} else {
			Vector pieces = new Vector();
			pieces.addElement(tv);
			inStock.put(model, pieces);
		}
		setChanged();
		notifyObservers(model);
	}
	
	/**
	 * Sell product and notifies the observer.
	 * @param model product id.
	 */
	public void sell(String model) {
		TV sold = null;
		if(inStock.containsKey(model)) {
			Vector pieces = (Vector) inStock.get(model);
			sold = (TV) pieces.remove(pieces.size()-1);
			System.out.println("Sold TV " + sold.hashCode());
			if(pieces.isEmpty())	
				inStock.remove(model);
			setChanged();
			notifyObservers(sold);
		} else {
			System.out.println("Acquired Model "+model+" is out of order!");
		}
	}
	
	/**
	 * @return The number of goods.
	 */
	public int getPresence() {
		return inStock.size();
	}
	
	/**
	 * Prints out the availability of the store.
	 */
	public void showStock() {
		for (Enumeration e = inStock.keys(); e.hasMoreElements();) {
			String id = (String) e.nextElement();
			System.out.println("Model#"+id);
		}
	}

}
