package com.sirma.itt.javacourse.objects.store;

import java.util.ArrayList;



public class Store {

	// class private members
	private ArrayList<Employee> employee;
	private ArrayList<Client> clients;
	private ArrayList<Product> products;
	
	public ArrayList<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(ArrayList<Employee> employee) {
		this.employee = employee;
	}
	public ArrayList<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}


}
