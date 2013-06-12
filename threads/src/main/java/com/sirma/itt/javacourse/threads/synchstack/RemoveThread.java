package com.sirma.itt.javacourse.threads.synchstack;


/**
 * RemoveThread class. Create and starts thread which remove element from stack. 
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class RemoveThread  extends Thread {

	// class private members
	private Thread thread;
	private SynchronizedStack stack;
	
	/**
	 * Constructor.
	 */
	public RemoveThread(SynchronizedStack stack) {
		this.stack = stack;
	}
	
	/**
	 * Call stack remove method.
	 */
	public void run() {
		stack.remove();
	}
}
