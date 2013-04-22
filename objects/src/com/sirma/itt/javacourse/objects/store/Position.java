package com.sirma.itt.javacourse.objects.store;

/**
 * Keep information for all positions in store.
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Position {

	// class private members
	private int ID;
	private String position;
	private int fullTime;

	/**
	 * Get ID.
	 * 
	 * @return
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set ID.
	 * 
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Get employee's position.
	 * 
	 * @return
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Set employees position.
	 * 
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Check is employee at full time or not.
	 * 
	 * @return
	 */
	public int getFullTime() {
		return fullTime;
	}

}
