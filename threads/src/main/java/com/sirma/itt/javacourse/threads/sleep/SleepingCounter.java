package com.sirma.itt.javacourse.threads.sleep;

/**
 * TwoThreadsCounter class. Create and starts thread. 
 * Increase value of the counter with 1 each second while the thread is running.
 * 
 * @version 1.1 04 Jun 2013
 * @author Stella Djulgerova
 */
public class SleepingCounter extends Thread {

	// this flag will be raised when threads have to stop.
	private static boolean stop;
	
	private int counter;
	private int maxCounterValue;
	private int sleepTime;
	
	/**
	 * Constructor.
	 * Set max allowed counter value.
	 * 
	 * @param maxCounterValue - max allowed counter value
	 */
	public SleepingCounter(int maxCounterValue, int sleepTime) {
		this.maxCounterValue = maxCounterValue;
		this.sleepTime = sleepTime;
	}
	
	/**
	 * Increments counter with 1 each second until max allowed counter value
	 * is reached.
	 */
	public void run() {
		
		while (counter < maxCounterValue) {
			try {
				Thread.sleep(sleepTime);
				System.out.println(this.getName() + " ---> " + counter);
				counter++;
				if ( counter == maxCounterValue ) {
					stop = true;
				}
				if (stop) return;
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}