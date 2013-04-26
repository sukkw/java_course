package com.sirma.itt.javacourse.reflection;

/**
 * Represent information for person.
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public abstract class Person {

	// class private members
	private int ID;
	private String name;
	private String phone;
	private String email;

	/**
	 * Get name.
	 * 
	 * @return name
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
	 * Get phone.
	 * 
	 * @return phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Set phone.
	 * 
	 * @param phone - phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get e-mail.
	 * 
	 * @return e-mail
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
	 * @return ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set ID.
	 * 
	 * @param ID
	 */
	public void setID(int iD) {
		ID = iD;
	}

}
