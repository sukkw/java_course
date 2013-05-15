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
		}
		
		elements[last] = obj;
		last++;
		System.out.println("Dobavqneto e uspeshno!");

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
		}

		last--;
		elements[last] = null;	
		System.out.println("Iztrivaneto e uspeshno!");
		
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

	/**
	 * Read string from console and do action.
	 */
	public void read() {
		boolean checker = true;
		do {
			Scanner input = new Scanner(System.in);
			String str;
			System.out.print("A(dd) / D(elete) / P(rint) / E(xit)");
			str = input.next();

			switch (str) {

				case "A":
					try {
						add("test");
					} catch (ListException e) {
						e.printStackTrace();
					}
					break;
				case "D":
					try {
						remove();
					} catch (ListException e) {
						e.printStackTrace();
					}
					break;
				case "P":
					printAllElements();
					break;
				case "E":
					checker = false;
					break;
				default:
					break;
			}
		} while (checker);
	}
}
