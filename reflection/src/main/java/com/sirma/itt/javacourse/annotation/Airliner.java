package com.sirma.itt.javacourse.annotation;

/**
 * Represent information for airliner.
 * 
 * @version 1.1 27 April 2013
 * @author Stella Djulgerova
 */
@PlaneAnnotation(2)
public class Airliner extends Plane {
	
	//class private members
	private int maxPassengers;

	/**
	 * Get plain maximum allowed passengers.
	 * @return - maximum allowed passengers
	 */
	public int getMaxPassengers() {
		return maxPassengers;
	}

	/**
	 * Set plain max allowed passengers.
	 * @param maxPassengers - maximum allowed passengers
	 */
	public void setMaxPassangers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
}
