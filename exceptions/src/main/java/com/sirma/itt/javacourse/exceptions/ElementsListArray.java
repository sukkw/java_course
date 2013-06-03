package com.sirma.itt.javacourse.exceptions;

import java.util.Scanner;

/**
 * Add, delete and print array elements.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class ElementsListArray {

	// class private members
	private Object[] elements;
	private int last;

	/**
	 * Constructor.
	 * 
	 * @param elements - array of elements
	 */
	public ElementsListArray(Object[] elements) {
		this.elements = elements;
		this.last = 0;
	}

	/**
	 * Add element into array.
	 * 
	 * @param obj - element to be added
	 * @return array with new inserted element
	 * @throws ListException 
	 */
	public Object[] add(Object obj) throws ListException {
		
		if(elements.length <= last) {
			throw new ListException("Dobavqneto e nevuzmojno!");
		} else {
			elements[last] = obj;
			last++;
		}

		return elements;
	}

	/**
	 * Remove element from array.
	 * 
	 * @return array after last element is deleted
	 * @throws ListException 
	 */
	public Object[] remove() throws ListException {
		
		if(last <= 0) {
			throw new ListException("Iztrivaneto e nevuzmojno!");
		} else {
			last--;
			elements[last] = null;	
		}
		
		return elements;
	}

	/**
	 * Print all array elements.
	 */
	public void printAllElements() {

		// if first element is empty return
		if (elements[0] == null) {
			System.out.println("Masiva e prazen");
			return;
		}

		// print all elements on screen
		for (Object ele : elements) {
			if (ele != null) {
				System.out.println(ele);
			}
		}

	}
}
