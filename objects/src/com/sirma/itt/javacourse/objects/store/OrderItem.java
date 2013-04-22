package com.sirma.itt.javacourse.objects.store;

/**
 * Keep information for order items.
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
	 * Get itemorder price.
	 * 
	 * @return
	 */
	public double getPrice() {
		return qty * product.getPrice();
	}

	/**
	 * Get ID.
	 * 
	 * @return
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set ID.
	 * 
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Get order ID.
	 * 
	 * @return
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * Set order ID.
	 * 
	 * @param orderID
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	/**
	 * Get product.
	 * 
	 * @return
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Set product.
	 * 
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Get quantity.
	 * 
	 * @return
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * Set quantity.
	 * 
	 * @param qty
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}
}
