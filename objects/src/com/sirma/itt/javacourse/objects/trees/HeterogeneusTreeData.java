package com.sirma.itt.javacourse.objects.trees;

/**
 * Data used to fill binary tree nodes.
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class HeterogeneusTreeData implements Comparable {

	// class private members
	private Object data;

	/**
	 * Constructor.
	 * 
	 * @param data - value to be added (can be Integer, String, Double etc..)
	 */
	public HeterogeneusTreeData(Object data) {
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
	public int compareTo(Object o) {
		return new String(this.data.toString()).compareTo(o.toString());
	}
}
