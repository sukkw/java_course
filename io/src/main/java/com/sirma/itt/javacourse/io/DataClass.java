package com.sirma.itt.javacourse.io;

import java.io.Serializable;

/**
 * Class with data for serialization.
 * 
 * @version 1.1 02 May 2013
 * @author Stella Djulgerova
 */
public class DataClass implements Serializable {

	// class private members
	private String name;
	private double value;
	private int number;
	private int qty;
	private boolean isAvailable;
	
	/**
	 * Class constructor.
	 * @param name - name of the item
	 * @param value - value of the item
	 * @param number - number of the item
	 */
	public DataClass(String name, double value, int number) {
		this.name = name;
		this.value = value;
		this.number = number;
	}

	/**
	 * Get item name.
	 * @return - item name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set item name.
	 * @param name - item name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get item value.
	 * @return - item value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Set item value.
	 * @param value - item value
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Get item number.
	 * @return - item number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Set item number.
	 * @param number - item number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Get item quantity.
	 * @return - item quantity
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * Set item quantity.
	 * @param qty - quantity
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
	 * Check is item available.
	 * @return - is item available 
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * Set is item available or not.
	 * @param isAvailable - true or false
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
