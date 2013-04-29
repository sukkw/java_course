package com.sirma.itt.javacourse.annotation;

/**
 * Represent information for plane.
 * 
 * @version 1.1 27 April 2013
 * @author Stella Djulgerova
 */
public abstract class Plane {

	// class private members
	private int number;
	private String mark;
	private String model;
	
	/**
	 * Plane is flying.
	 */
	protected void fly() {
		
	}
	
	/**
	 * Plain fuel level.
	 * @return fuel level
	 */
	protected double fuel(){
		return 0;
	}
	
	/**
	 * Plain speed.
	 * @return plain speed
	 */
	protected double speed() {
		return number;
	}

	/**
	 * Get plain serial number.
	 * @return - serial number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Set plain serial number.
	 * @param number - serial number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Get plain mark.
	 * @return - plain mark
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * Set plain mark.
	 * @param mark - plain mark
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * Get plain model.
	 * @return - plain model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Set plain model.
	 * @param model - plain model
	 */
	public void setModel(String model) {
		this.model = model;
	}
}
