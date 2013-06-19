package com.sirma.itt.javacourse.gui.reverse;

import java.util.ArrayList;

/**
 * MementoHandler class. Keep all memento objects.
 *
 * @version 1.1 19 June 2013
 * @author Stella Djulgerova
 */
class MementoHandler {

	ArrayList<Memento> savedMessages = new ArrayList<Memento>();
	
	/**
	 * Add memento object
	 * @param object - object to be saved
	 */
	public void addMemento(Memento object) { 
		savedMessages.add(object); 
	}

	/**
	 * Get memento object.
	 * @param index - object index
	 * @return memento object
	 */
	public Memento getMemento(int index) { 
		return savedMessages.get(index); 
	}
} 