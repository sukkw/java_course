package com.sirma.itt.javacourse.objects.trees;

/**
 * Data used to fill binary tree nodes
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class HeterogeneusTreeData implements Comparable<HeterogeneusTreeData> {

	// class private members
	private int key;
	private Object data;

	/**
	 * Constructor
	 * 
	 * @param key
	 * @param data
	 */
	public HeterogeneusTreeData(int key, Object data) {
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
	public Object getData() {
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

	/**
	 * Compare value of two keys
	 * 
	 */
	public int compareTo(HeterogeneusTreeData other) {
		return new Integer(this.key).compareTo(other.key);
	}
}
