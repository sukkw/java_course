package com.sirma.itt.javacourse.servercommands;

import java.util.Observable;

/**
 * This class represents an abstract server command.
 * 
 * @version 1.1 30 July 2013
 * @author Stella Djulgerova
 */
public abstract class Command extends Observable {

	/**
	 * Execute the command
	 */
	public abstract void execute();
	
	/**
	 * Notify all observers
	 * @param obj - object to be sent to observers
	 */
	public void notifyObserver(Object obj) {
		setChanged(); 
		notifyObservers(obj);
	}
}