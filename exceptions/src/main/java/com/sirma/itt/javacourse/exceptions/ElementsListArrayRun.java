package com.sirma.itt.javacourse.exceptions;

/**
 * Elements list run class.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class ElementsListArrayRun {

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Object[] elements = new Object[5];
		ElementsListArray elList = new ElementsListArray(elements);
		elList.read();
	}
}
