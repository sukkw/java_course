package com.sirma.itt.javacourse.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * TV observer class. Take care about updates 
 * when any of the observable objects have been changed.
 * 
 * @version 1.1 22 May 2013
 * @author Stella Djulgerova
 */
public class TVObserver implements Observer {

	// class private members
	private SoldOut soldOut;
	
	/**
	 * Constructor.
	 */
	public TVObserver() {
		soldOut = new SoldOut();
	}
	
	/**
	 * Called when any of the observable objects have been changed. 
	 */
	public void update(Observable obs, Object arg) {
		System.out.println("Observer is notified... ");
		if (obs instanceof TVStore) {
			if(arg instanceof TV) {	
				System.out.println("TV....");
				soldOut.add((TV) arg);
			} else {	
				System.out.println("In stock....");
				soldOut.remove((String) arg);
			}	
		}
	}
}
