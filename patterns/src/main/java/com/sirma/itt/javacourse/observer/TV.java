package com.sirma.itt.javacourse.observer;

/**
 * Contain information about different type of TVs.
 * 
 * @version 1.1 21 May 2013
 * @author Stella Djulgerova
 */
public class TV {
	
	private String mark;
	private int price;
	
	/**
	 * Constructor.
	 */
	public TV(String mark) {
		this.mark = mark;
	}
	
	/**
	 * Set the price.
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Get the price.
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Get the mark.
	 * @return mark
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * Set the mark.
	 * @param mark
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}
}