package com.sirma.itt.javacourse.threads.synchstack;

/**
 * AddThread class. Create and starts thread which add element to stack.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class AddThread extends Thread {

	// class private members
	private SynchronizedStack stack;
	private Object data;
	
	/**
	 * Constructor.
	 * Initialize all variables.
	 */
	public AddThread(SynchronizedStack stack, Object data) {
		this.stack = stack;
		this.data = data;
	}
	
	/**
	 * Call stack add method.
	 */
	public void run() {
		stack.add(data);
	}
}