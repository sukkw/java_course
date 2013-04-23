package com.sirma.itt.javacourse.objects.store;

import java.util.ArrayList;

/**
 * Keep information for clients.
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Client extends Person implements ClientImpl {

	// class private members
	private ArrayList<Order> order;
	private int paymentMethod;

	/**
	 * Allow client to make an order.
	 */
	public void makeOrde() {

	}

	/**
	 * Allow client cancel order.
	 */
	public void cancelOrder() {

	}

	/**
	 * Get orders.
	 * 
	 * @return all orders of a client
	 */
	public ArrayList<Order> getOrder() {
		return order;
	}

	/**
	 * Set orders.
	 * 
	 * @param order
	 */
	public void setOrder(ArrayList<Order> order) {
		this.order = order;
	}

	/**
	 * Get payment method.
	 * 
	 * @return client payment method
	 */
	public int getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Set payment method.
	 * 
	 * @param paymentMethod
	 */
	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
