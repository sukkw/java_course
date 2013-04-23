package com.sirma.itt.javacourse.objects.store;

/**
 * Keep information for departments.
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Department {

	// class private members
	private int ID;
	private String name;

	/**
	 * Get ID.
	 * 
	 * @return ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set ID.
	 * 
	 * @param ID
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Get department name.
	 * 
	 * @return department name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set department name.
	 * 
	 * @param name - department name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
