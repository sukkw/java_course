package com.sirma.itt.javacourse.threads.counter;

/**
 * Counter class. Create and starts thread. Increase value of the counter
 * while the thread is running.
 * 
 * @version 1.1 04 Jun 2013
 * @author Stella Djulgerova
 */
public class Counter extends Thread {
	
	// class private members
	private long maxCounterValue;
	private long counter;
	
	private boolean stopped;

	/**
	 * Constructor. Set max allowed value of counter.
	 * 
	 * @param maxCounterValue - max allowed counter value
	 */
	public Counter(long maxCounterValue) {
		this.maxCounterValue = maxCounterValue;
	}
	
	/**
	 * Returns the value of the counter.
	 * @return - value of the counter.
	 */
	public long getValue() {
		return counter;
	}
	
	/**
	 * Increments counter until this thread is 
	 * interrupted or max allowed value of counter is reached.
	 */
	public void run() {
		while(counter < maxCounterValue && !isStopped()) {
			counter++;	
		}
	}
	
	/**
	 * Stop counter thread.
	 */
	public synchronized void stopCounter() {
		//this.interrupt();
		stopped = true;
	}
	
	/**
	 * Detect if thread have to stop.
	 */
	public boolean isStopped() {
		return stopped;
	}
}