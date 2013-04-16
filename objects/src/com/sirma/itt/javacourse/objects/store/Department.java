package com.sirma.itt.javacourse.objects.store;

/**
 * Keep information for departments
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Department {

	//class private members
	private int ID;
	private String name;
	
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
	 * get department name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set department name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
