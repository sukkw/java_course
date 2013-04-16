package com.sirma.itt.javacourse.objects.store;

public class Product {

	// class private members
	private double price;
	private String mark;
	private String model;

	/**
	 * get Price
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * set price
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * get mark
	 * 
	 * @return
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * set mark
	 * 
	 * @param mark
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * get model
	 * 
	 * @return
	 */
	public String getModel() {
		return model;
	}

	/**
	 * set model
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

}
