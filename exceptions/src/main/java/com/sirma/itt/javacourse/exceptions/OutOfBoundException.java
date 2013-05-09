package com.sirma.itt.javacourse.exceptions;

/**
 * Create new exception if a number is lower than 0 or bigger than 100.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class OutOfBoundException extends Exception {

	private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * @param message - exception information
     */
	public OutOfBoundException(String message) {
		super(message);
	}
}
