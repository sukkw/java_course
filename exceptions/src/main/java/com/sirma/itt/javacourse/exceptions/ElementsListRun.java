package com.sirma.itt.javacourse.exceptions;

/**
 * Elements list run class.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class ElementsListRun {

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Object[] elements = new Object[5];
		ElementsList elList = new ElementsList(elements);
		elList.read();
	}
}
