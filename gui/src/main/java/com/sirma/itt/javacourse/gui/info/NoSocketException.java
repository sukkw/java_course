package com.sirma.itt.javacourse.gui.info;

/**
 * Custom exception. This exception is thrown if server is closed
 * while a client is connected.
 * 
 * @version 1.1 18 June 2013
 * @author Stella Djulgerova
 */
public class NoSocketException extends RuntimeException {

	private static final long serialVersionUID = -1L;

    /**
     * Constructor.
     * @param message - exception information
     */
	public NoSocketException (String message) {
		super(message);
	}
}
