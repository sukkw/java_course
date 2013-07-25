package com.sirma.itt.javacourse.gui.reverse;

/**
 * Messenger class. Create memento pattern objects.
 *
 * @version 1.1 19 June 2013
 * @author Stella Djulgerova
 */
public class Memento {

	private String message;
	
	/**
	 * Constructor. 
	 * @param message - user message
	 */
	public Memento(String message) { 
		this.message = message; 
	}

	/**
	 * Get message
	 * @return - message
	 */
	public String getSavedMessage() { 
		return message; 
	}
	
}