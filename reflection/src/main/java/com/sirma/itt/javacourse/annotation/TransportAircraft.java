package com.sirma.itt.javacourse.annotation;

/**
 * Represent information for transport aircraft.
 * 
 * @version 1.1 27 April 2013
 * @author Stella Djulgerova
 */
@PlaneAnnotation(1)
public class TransportAircraft extends Plane {
	
	//class private members
	private double maximumLoad;

	/**
	 * Get plain maximum allowed load.
	 * @return - maximum allowed load
	 */
	public double getMaximumLoad() {
		return maximumLoad;
	}

	/**
	 * Set plain max allowed load.
	 * @param maximumLoad - maximum allowed load
	 */
	public void setMaximumLoad(double maximumLoad) {
		this.maximumLoad = maximumLoad;
	}
}
