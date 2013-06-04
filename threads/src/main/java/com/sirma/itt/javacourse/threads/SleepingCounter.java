package com.sirma.itt.javacourse.threads;

/**
 * TwoThreadsCounter class. Create and starts thread. 
 * Increase value of the counter with 1 each second while the thread is running.
 * 
 * @version 1.1 04 Jun 2013
 * @author Stella Djulgerova
 */
public class SleepingCounter implements Runnable {

	// this flag will be raised when threads have to stop.
	private static boolean stop;
	
	private Thread thread;
	private int count;
	private int maxCounterValue;
	
	/**
	 * Constructor. Create thread and start it.
	 * Set max allowed counter value.
	 * 
	 * @param maxCounterValue - max allowed counter value
	 * @param name - thread name
	 */
	public SleepingCounter(int maxCounterValue, String name) {
		
		if(name == null) {
			return;
		}
		
		this.maxCounterValue = maxCounterValue;
		thread = new Thread(this, name);
		thread.start();
	}
	
	/**
	 * Increments counter with 1 each second until max allowed counter value
	 * is reached.
	 */
	public void run() {
		
		while (count < maxCounterValue) {
			try {
				thread.sleep(1000);
				System.out.println("----> " + thread.getName() + " " + count);
				count++;
			} catch (InterruptedException e) {
				return;
			}
			if ( count == maxCounterValue ) {
				stop = true;
			}
			if (stop) return;
		}
	}
}