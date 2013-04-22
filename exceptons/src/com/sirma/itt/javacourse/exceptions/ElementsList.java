package com.sirma.itt.javacourse.exceptions;

import java.util.Scanner;

/**
 * Add, delete and print array elements.
 * 
 * @version 1.1 20 April 2013
 * @author Stella Djulgerova
 */
public class ElementsList {

	// class private members
	private Object[] elements;

	/**
	 * Constructor.
	 * 
	 * @param elements
	 */
	public ElementsList(Object[] elements) {
		this.elements = elements;
	}

	/**
	 * Add element into array.
	 * 
	 * @param obj
	 */
	public void add(Object obj) {
		int index = this.elements.length + 1;
		for (int i = 0; i < this.elements.length; i++) {
			if (this.elements[i] == null) {
				index = i;
				break;
			}
		}

		// check if array is full
		try {
			this.elements[index] = obj;
			System.out.println("Dobavqneto e uspeshno!");
		} catch (ArrayIndexOutOfBoundsException exc) {
			System.out.println("Dobavqneto e nevuzmojno!");
		}

	}

	/**
	 * Remove element from array.
	 */
	public void remove() {
		int index = 0;
		if (this.elements[this.elements.length - 1] != null) {
			index = this.elements.length - 1;
		} else {
			for (int i = 0; i < this.elements.length; i++) {
				if (this.elements[i] == null) {
					index = i - 1;
					break;
				}
			}
		}

		// check if array is empty
		try {
			this.elements[index] = null;
			System.out.println("Iztrivaneto e uspeshno!");
		} catch (ArrayIndexOutOfBoundsException exc) {
			System.out.println("Iztrivaneto e nevuzmojno!");
		}
	}

	/**
	 * Print all array elements.
	 * 
	 * @param elements
	 */
	public void printAllElements() {

		// if first element is empty return
		if (this.elements[0] == null) {
			System.out.println("Masiva e prazen");
			return;
		}

		// print all elements on screen
		for (Object ele : this.elements) {
			if (ele != null) {
				System.out.println(ele);
			}
		}

	}

	/**
	 * Read string from console and do action.
	 * 
	 * @return
	 * @return
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
