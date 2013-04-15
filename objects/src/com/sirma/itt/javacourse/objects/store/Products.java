package com.sirma.itt.javacourse.objects.store;

/**
 * Abstract class base for all products
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public abstract class Products {

	// classs private members
	private double price;
	private int size;
	private String mark;
	private String model;

	/**
	 * Get product price
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set product price
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get size
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Set size
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Get mark
	 * 
	 * @return
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * Set mark
	 * 
	 * @param mark
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * Get model
	 * 
	 * @return
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Set model
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

}
