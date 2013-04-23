package com.sirma.itt.javacourse.objects.store;

/**
 * Keep information for products in store.
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Product {

	// class private members
	private double price;
	private String mark;
	private String model;

	/**
	 * Get Price.
	 * 
	 * @return product price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set price.
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get mark.
	 * 
	 * @return product mark
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * Set mark.
	 * 
	 * @param mark
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * Get model.
	 * 
	 * @return product model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Set model.
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

}
