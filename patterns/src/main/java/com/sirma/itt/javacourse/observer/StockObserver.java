package com.sirma.itt.javacourse.observer;

import java.util.Observable;
import java.util.Observer;

public class StockObserver implements Observer {

	private ForSale forSale;
	private SoldOut soldOut;
	
	public StockObserver() {
		forSale = new ForSale();
		soldOut = new SoldOut();
	}
	
	/**
	 * Called when any of the observable objects have been changed. 
	 */
	public void update(Observable obs, Object arg) {
		if (obs instanceof TVStore) {
			if(arg instanceof TV) {	
				forSale.setOrder(arg.hashCode()+ "");
				soldOut.add((TV) arg);
			} else {				
				soldOut.remove((String) arg);
			}	
		}
	}
}
