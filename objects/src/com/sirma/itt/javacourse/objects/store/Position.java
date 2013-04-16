package com.sirma.itt.javacourse.objects.store;

/**
 * Keep information for all positions in store
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Position {

	//class private members
	private int ID;
	private String position;
	private int fullTime;
	
	/**
	 * get ID
	 * @return
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * set ID
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * get employee's position
	 * @return
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * set employees position
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * check is employee at full time or not
	 * @return
	 */
	public int getFullTime() {
		return fullTime;
	}
	
}
