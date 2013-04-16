package com.sirma.itt.javacourse.objects.store;

/**
 * Keep information for order items
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class OrderItem {

	// class private members
	private int ID;
	private int orderID;
	private Product product;
	private int qty;

	/**
	 * get itemorder price
	 * 
	 * @return
	 */
	public double getPrice() {
		return qty * product.getPrice();
	}

	/**
	 * get ID
	 * 
	 * @return
	 */
	public int getID() {
		return ID;
	}

	/**
	 * set ID
	 * 
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * get order ID
	 * 
	 * @return
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * set order ID
	 * 
	 * @param orderID
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	/**
	 * get product
	 * 
	 * @return
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * set product
	 * 
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * get quantity
	 * 
	 * @return
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * set quantity
	 * 
	 * @param qty
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}
}
