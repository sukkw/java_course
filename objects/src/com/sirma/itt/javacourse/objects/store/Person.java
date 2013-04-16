package com.sirma.itt.javacourse.objects.store;


public abstract class Person {

	// classs private members
	private int ID;
	private String name;
	private Address address;
	private String phone;
	private String email;

	/**
	 * get name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * set name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get address
	 * 
	 * @return
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * set address
	 * 
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * get phone
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * set phone
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * get email
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * set email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * get ID
	 * @return
	 */
	public int getID() {
		return ID;
	}

	/**
	 * set ID
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

}
