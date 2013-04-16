package com.sirma.itt.javacourse.objects.store;

/**
 * Keep address information
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Address {

	// class private members
	private int ID;
	private String street;
	private String city;
	private String postalCode;
	private String Country;

	/**
	 * get street
	 * 
	 * @return
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * set street
	 * 
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Get city
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * set city
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * get post code
	 * 
	 * @return
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * set post code
	 * 
	 * @param postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * get country
	 * 
	 * @return
	 */
	public String getCountry() {
		return Country;
	}

	/**
	 * set country
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		Country = country;
	}

	/**
	 * get ID
	 * 
	 * @return
	 */
	public int getID() {
		return ID;
	}

	/**
	 * set ID
	 * 
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}
}
