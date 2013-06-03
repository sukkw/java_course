package com.sirma.itt.javacourse.annotation;

/**
 * Represent information for military airplane.
 * 
 * @version 1.1 27 April 2013
 * @author Stella Djulgerova
 */
public abstract class MilitaryAircraft extends Plane {

	//class private members
	private int baseNumber;

	/**
	 * Get number of the base plane belongs to.
	 * @return  - number of the base 
	 */
	public int getBaseNumber() {
		return baseNumber;
	}

	/**
	 * Set number of the base plane belongs to.
	 * @param baseNumber - plane base number
	 */
	public void setBaseNumber(int baseNumber) {
		this.baseNumber = baseNumber;
	}
}