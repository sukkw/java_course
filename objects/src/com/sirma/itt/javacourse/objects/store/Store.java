package com.sirma.itt.javacourse.objects.store;

import java.util.ArrayList;

public class Store {

	// class private members
	private ArrayList<Employee> employees;
	private ArrayList<Client> clients;
	private ArrayList<Product> products;
	private ArrayList<Department> departments;

	/**
	 * get Emoployees
	 * @return
	 */
	public ArrayList<Employee> getEmployee() {
		return employees;
	}

	/**
	 * Set employees
	 * @param employees
	 */
	public void setEmployee(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * get clients
	 * @return
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}

	/**
	 * set clients
	 * @param clients
	 */
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	/**
	 * get products
	 * @return
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * set products
	 * @param products
	 */
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

}