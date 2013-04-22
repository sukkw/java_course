package com.sirma.itt.javacourse.objects.store;

import java.util.ArrayList;

/**
 * Represents store.
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Store {

	// class private members
	private ArrayList<Employee> employees;
	private ArrayList<Client> clients;
	private ArrayList<Product> products;
	private ArrayList<Department> departments;

	/**
	 * Get emoployees.
	 * 
	 * @return
	 */
	public ArrayList<Employee> getEmployee() {
		return employees;
	}

	/**
	 * Set employees.
	 * 
	 * @param employees
	 */
	public void setEmployee(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * Get clients.
	 * 
	 * @return
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}

	/**
	 * Set clients.
	 * 
	 * @param clients
	 */
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	/**
	 * Get products.
	 * 
	 * @return
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * Set products.
	 * 
	 * @param products
	 */
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

}