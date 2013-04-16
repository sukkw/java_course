package com.sirma.itt.javacourse.objects.store;

import java.util.ArrayList;



public class Store {

	// class private members
	private ArrayList<Employee> employees;
	private ArrayList<Client> clients;
	private ArrayList<Product> products;
	private ArrayList<Department> departments;
	
	public ArrayList<Employee> getEmployee() {
		return employees;
	}
	public void setEmployee(ArrayList<Employee> employees) {
		this.employees = employees;
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
