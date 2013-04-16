package com.sirma.itt.javacourse.objects.store;

import java.util.ArrayList;
import java.util.Date;

/**
 * Keep information for orders
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
	 * add item to order
	 */
	public void addItem() {

	}

	/**
	 * delete item from order
	 */
	public void deleteItem() {

	}

	/**
	 * get order id
	 * 
	 * @return
	 */
	public int getID() {
		return ID;
	}

	/**
	 * set order id
	 * 
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * get client id
	 * 
	 * @return
	 */
	public int getClientID() {
		return clientID;
	}

	/**
	 * set client ID
	 * 
	 * @param clientID
	 */
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	/**
	 * get items
	 * 
	 * @return
	 */
	public ArrayList<OrderItem> getOrder() {
		return order;
	}

	/**
	 * set items
	 * 
	 * @param order
	 */
	public void setOrder(ArrayList<OrderItem> order) {
		this.order = order;
	}

	/**
	 * get order date
	 * 
	 * @return
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * set order date
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * get Order status
	 * @return
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * set order status
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * get order number
	 * @return
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * set order number
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}
}
