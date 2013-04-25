package com.sirma.itt.javacourse.exceptions;

import java.util.Scanner;

/**
 * Add, delete and print array elements.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class ElementsList {

	// class private members
	private Object[] elements;

	/**
	 * Constructor.
	 * 
	 * @param elements - array of elements
	 */
	public ElementsList(Object[] elements) {
		this.elements = elements;
	}

	/**
	 * Add element into array.
	 * 
	 * @param obj - element to be added
	 * @return array with new inserted element
	 */
	public Object[] add(Object obj) {
		int index = elements.length + 1;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == null) {
				index = i;
				break;
			}
		}

		// check if array is full
		try {
			elements[index] = obj;
			System.out.println("Dobavqneto e uspeshno!");
		} catch (ArrayIndexOutOfBoundsException exc) {
			System.out.println("Dobavqneto e nevuzmojno!");
		}
		return elements;
	}

	/**
	 * Remove element from array.
	 * 
	 * @return array after last element is deleted
	 */
	public Object[] remove() {
		int index = 0;
		if (elements[elements.length - 1] != null) {
			index = elements.length - 1;
		} else {
			for (int i = 0; i < elements.length; i++) {
				if (elements[i] == null) {
					index = i - 1;
					break;
				}
			}
		}

		// check if array is empty
		try {
			elements[index] = null;
			System.out.println("Iztrivaneto e uspeshno!");
		} catch (ArrayIndexOutOfBoundsException exc) {
			System.out.println("Iztrivaneto e nevuzmojno!");
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
					add("test");
					break;
				case "D":
					remove();
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
