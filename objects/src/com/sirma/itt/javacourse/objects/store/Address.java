package com.sirma.itt.javacourse.objects.store;

/**
 * Keep address information.
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
	 * Get street.
	 * 
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Set street.
	 * 
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Get city.
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set city.
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get post code.
	 * 
	 * @return post code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Set post code.
	 * 
	 * @param post code
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Get country.
	 * 
	 * @return country
	 */
	public String getCountry() {
		return Country;
	}

	/**
	 * Set country.
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		Country = country;
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
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}
}
