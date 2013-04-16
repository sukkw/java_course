package com.sirma.itt.javacourse.objects.store;

import java.util.ArrayList;

/**
 * Keep information for clients
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Client extends Person {
	
	//class private members
	private ArrayList<Order> order;
	private int paymentMethod;
	
	/**
	 * allow client to make an order
	 */
	public void makeOrder() {
		
	}
	
	/**
	 * allow client cancel order
	 */
	public void cancelOrder() {
		
	}
	
	/**
	 * get orders
	 * @return
	 */
	public ArrayList<Order> getOrder() {
		return order;
	}
	
	/**
	 * set orders
	 * @param order
	 */
	public void setOrder(ArrayList<Order> order) {
		this.order = order;
	}
	
	/**
	 * get payment method
	 * @return
	 */
	public int getPaymentMethod() {
		return paymentMethod;
	}
	
	/**
	 * set payment method
	 * @param paymentMethod
	 */
	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
