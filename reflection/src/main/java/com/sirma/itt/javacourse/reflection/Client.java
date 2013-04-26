package com.sirma.itt.javacourse.reflection;

/**
 * Keep information for clients.
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Client extends Person implements ClientImpl {

	// class private members
	private int paymentMethod = 1;
	public String clientNumber;
	
	/**
	 * Class default constructor
	 */
	public void client() {
	}
	
	/**
	 * Constructor. Create client with given name
	 * @param name - the name of the client
	 */
	public void client(int paymentMethod, String name) {
		this.setName(name);
		System.out.println("Client name is " + name + " payment " + paymentMethod);
	}

	/**
	 * Allow client to make an order.
	 */
	public void makeOrde() {
		calculateOrderVal();
	}

	/**
	 * Allow client cancel order.
	 */
	public void cancelOrder() {

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
	 * @param paymentMethod - how the client will pay
	 */
	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	/**
	 * Calculate value of client order
	 * @return value of the order
	 */
	private double calculateOrderVal() {
		return 56.5;
	}
	
	/**
	 * Calculate value of client order
	 * @return value of the order
	 */
	private String orderInfo(int clientID, String clientNumber) {
		return "Access to private method " + clientID + "  " + clientNumber;
	}

}
