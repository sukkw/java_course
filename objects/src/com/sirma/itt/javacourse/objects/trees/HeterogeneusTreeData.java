package com.sirma.itt.javacourse.objects.trees;

/**
 * Data used to fill binary tree nodes.
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class HeterogeneusTreeData<T> implements Comparable<T> {

	// class private members
	private T data;

	/**
	 * Constructor.
	 * 
	 * @param data - value to be added (can be Integer, String, Double etc..)
	 */
	public HeterogeneusTreeData(T data) {
		this.data = data;
	}

	/**
	 * Get data value.
	 * 
	 * @return value
	 */
	public Object getData() {
		return data;
	}


	@Override
	public int compareTo(T dataToCompare) {
		return new String(this.data.toString()).compareTo(dataToCompare.toString());
	}
}
