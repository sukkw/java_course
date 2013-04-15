package com.sirma.itt.javacourse.objects.store;

/**
 * Abstract class base for all employees in store
 * 
 * @version 1.1 13 April 2013
 * @author Stella Djulgerova
 */
public abstract class Employees {
	
	// classs private members
	private String name;
	private String address;
	private String phone;
	private String email;
	private double selary;
	
	public abstract void doJob();

	/**
	 * Get employee name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set employee name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get employee address
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set employee address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get employee phone
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Set employee phone
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get employee email
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set employee email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * get employee selary
	 * @return
	 */
	public double getSelary() {
		return selary;
	}

	/**
	 * Set employee selary
	 * @param selary
	 */
	public void setSelary(double selary) {
		this.selary = selary;
	}

}
