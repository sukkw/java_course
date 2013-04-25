package com.sirma.itt.javacourse.exceptions;

/**
 * Create new exception if a number is lower than 0 or bigger than 100.
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class OutOfBoundException extends Exception {

	// class private members
	private final String error;

	/**
	 * Constructor.
	 * 
	 * @param error - error to be shown if exception occurs
	 */
	public OutOfBoundException(String error) {
		super(error);
		this.error = error;
	}

	/**
	 * Get error message.
	 * 
	 * @return error massage
	 */
	public String getError() {
		return error;
	}
}
