package com.sirma.itt.javacourse.threads.synch;


/**
 * AddThread class. Create and starts thread which add element to stack.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class AddThread implements Runnable {

	// class private members
	private Thread thread;
	private SynchronizedStack stack;
	private Object data;
	
	/**
	 * Constructor. Create and start thread.
	 * Initialize all variables.
	 */
	public AddThread(SynchronizedStack stack, Object data) {
		this.stack = stack;
		this.data = data;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Call stack add method.
	 */
	public void run() {
		stack.add(data);
	}
}
