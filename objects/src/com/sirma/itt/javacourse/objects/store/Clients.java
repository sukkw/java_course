package com.sirma.itt.javacourse.objects.store;

/**
 * Abstract class base for all clients in store
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public abstract class Clients {

	// classs private members
	private String name;
	private String address;
	private String phone;
	private String email;
	
	/**
	 * Get client name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set client name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get client address
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Set Client address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Get client phone
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Set client phone
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Get client email
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Set client email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
