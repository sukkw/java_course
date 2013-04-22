package com.sirma.itt.javacourse.objects.store;

import java.util.ArrayList;
import java.util.Date;

/**
 * Keep information for orders.
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Order {

	// class private members
	private int ID;
	private int clientID;
	private ArrayList<OrderItem> order;
	private Date date;
	private int status;
	private int number;

	/**
	 * Add item to order.
	 */
	public void addItem() {

	}

	/**
	 * Delete item from order.
	 */
	public void deleteItem() {

	}

	/**
	 * Get order id.
	 * 
	 * @return
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set order id.
	 * 
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Get client id.
	 * 
	 * @return
	 */
	public int getClientID() {
		return clientID;
	}

	/**
	 * Set client ID.
	 * 
	 * @param clientID
	 */
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	/**
	 * Get items.
	 * 
	 * @return
	 */
	public ArrayList<OrderItem> getOrder() {
		return order;
	}

	/**
	 * Set items.
	 * 
	 * @param order
	 */
	public void setOrder(ArrayList<OrderItem> order) {
		this.order = order;
	}

	/**
	 * Get order date.
	 * 
	 * @return
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Set order date.
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Get Order status.
	 * 
	 * @return
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Set order status.
	 * 
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Get order number.
	 * 
	 * @return
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Set order number.
	 * 
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
}
