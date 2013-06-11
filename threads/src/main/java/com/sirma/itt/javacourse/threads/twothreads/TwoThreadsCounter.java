package com.sirma.itt.javacourse.threads.twothreads;

/**
 * TwoThreadsCounter class. Create and starts thread. 
 * Increase value of the counter with 1 while the thread is running.
 * 
 * @version 1.1 04 Jun 2013
 * @author Stella Djulgerova
 */
public class TwoThreadsCounter extends Thread {

	// this flag will be raised when threads have to stop.
	private static boolean stop;
	
	private int maxCounterValue;
	private int counter;

	/**
	 * Constructor. Create thread with given name and start it.
	 * Set max allowed counter value.
	 * 
	 * @param maxCounterValue - max allowed counter value
	 */
	public TwoThreadsCounter(int maxCounterValue) {
		this.maxCounterValue = maxCounterValue;
	}

	/**
	 * Increments counter with 1 each second until max allowed counter value
	 * is reached.
	 */
	public void run() {
		
		while (counter < maxCounterValue) {

			System.out.println(this.getName() + " ---> " + counter);
			counter++;

			if ( counter == maxCounterValue ) {
				stop = true;
			}
			if (stop) return;
		}
	}
}