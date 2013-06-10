package com.sirma.itt.javacourse.threads;

/**
 * Counter class. Create and starts thread. Increase value of the counter
 * with 1 each second while the thread is running.
 * 
 * @version 1.1 04 Jun 2013
 * @author Stella Djulgerova
 */
public class Counter implements Runnable {
	
	// class private members
	private int maxCounterValue;
	private int count;
	private Thread thread;

	/**
	 * Constructor. Set max allowed value of counter.
	 * Create and starts thread.
	 * 
	 * @param maxCounterValue - max allowed counter value
	 */
	public Counter(int maxCounterValue) {
		this.maxCounterValue = maxCounterValue;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Get thread instance.
	 * @return - thread
	 */
	public Thread getThread() {
		return thread;
	}
	
	/**
	 * Returns the value of the counter.
	 * @return - value of the counter.
	 */
	public int getNumber() {
		return count;
	}
	
	/**
	 * Increments counter with 1 each second until this thread is 
	 * interrupted or max allowed value of counter is reached.
	 */
	public void run() {
		while(count < maxCounterValue) {
			try {
				thread.sleep(1000);
				count++;
			} catch (InterruptedException e) {
				return;
			}	
		}
	}
}