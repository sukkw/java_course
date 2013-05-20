package com.sirma.itt.javacourse.pool;

/**
 * Custom exception. Thrown to indicate that pool is 
 * either full or empty.
 * 
 * @version 1.1 20 May 2013
 * @author Stella Djulgerova
 */
public class PoolException extends Exception {

	private static final long serialVersionUID = 1L;

	public PoolException(String msg) {
		super(msg);
	}
}
