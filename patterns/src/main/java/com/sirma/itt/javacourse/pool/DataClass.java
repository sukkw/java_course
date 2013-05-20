package com.sirma.itt.javacourse.pool;

/**
 * Class with data for object pool.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class DataClass {

	// class private members
	private String name;
	private double value;
	private int number;
	private int qty;
	private boolean isAvailable;
	
	/**
	 * Class constructor.
	 */
	public DataClass() {
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
