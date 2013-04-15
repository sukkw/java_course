package com.sirma.itt.javacourse.objects.trees;

/**
 * Data used to fill homogeneus tree nodes
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class HomogeneusTreeData {

	// class private members
	private int key;
	private String data;

	/**
	 * Constructor
	 * 
	 * @param key
	 * @param data
	 */
	public HomogeneusTreeData(int key, String data) {
		this.key = key;
		this.data = data;
	}

	/**
	 * get key value
	 * 
	 * @return
	 */
	public int getKey() {
		return key;
	}

	/**
	 * Set key value
	 * 
	 * @param key
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * Get data value
	 * 
	 * @return
	 */
	public String getData() {
		return data;
	}

	/**
	 * Set data value
	 * 
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

}
