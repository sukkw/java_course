package com.sirma.itt.javacourse.objects.trees;

/**
 * Data used to fill binary tree nodes.
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class BinaryTreeData implements Comparable<BinaryTreeData> {

	// class private members
	private int key;
	private String data;

	/**
	 * Constructor.
	 * 
	 * @param key
	 * @param data
	 */
	public BinaryTreeData(int key, String data) {
		this.key = key;
		this.data = data;
	}

	/**
	 * Get key value.
	 * 
	 * @return
	 */
	public int getKey() {
		return key;
	}

	/**
	 * Set key value.
	 * 
	 * @param key
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * Get data value.
	 * 
	 * @return
	 */
	public String getData() {
		return data;
	}

	/**
	 * Set data value.
	 * 
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Compare value of two keys.
	 */
	public int compareTo(BinaryTreeData other) {
		return new Integer(this.key).compareTo(other.key);
	}
}
