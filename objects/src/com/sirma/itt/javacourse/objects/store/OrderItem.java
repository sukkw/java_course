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
	 * Get item order price.
	 * 
	 * @return price of order item
	 */
	public double getPrice() {
		return qty * product.getPrice();
	}

	/**
	 * Get ID.
	 * 
	 * @return item ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set ID.
	 * 
	 * @param item ID
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Get order ID.
	 * 
	 * @return order ID
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
	 * @return product
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
	 * @return quantity
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
