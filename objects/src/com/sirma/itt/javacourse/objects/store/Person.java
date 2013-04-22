package com.sirma.itt.javacourse.objects.store;

/**
 * represent information for person.
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public abstract class Person {

	// class private members
	private int ID;
	private String name;
	private Address address;
	private String phone;
	private String email;

	/**
	 * Get name.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get address.
	 * 
	 * @return
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Set address.
	 * 
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Get phone.
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Set phone.
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get e-mail.
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set e-mail.
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get ID.
	 * 
	 * @return
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set ID.
	 * 
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

}
