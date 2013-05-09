package com.sirma.itt.javacourse.exceptions;

/**
 * Create new exception if a list is full
 * 
 * @version 1.1 25 April 2013
 * @author Stella Djulgerova
 */
public class FullListException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * @param message - exception information
     */
    public FullListException(String message) {
            super(message);
    }
}
