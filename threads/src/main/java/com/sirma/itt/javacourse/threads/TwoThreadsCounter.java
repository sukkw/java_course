package com.sirma.itt.javacourse.threads;

import java.util.logging.Logger;

/**
 * TwoThreadsCounter class. Create and starts thread. 
 * Increase value of the counter with 1 each second while the thread is running.
 * 
 * @version 1.1 04 Jun 2013
 * @author Stella Djulgerova
 */
public class TwoThreadsCounter implements Runnable {

	// this flag will be raised when threads have to stop.
	private static boolean stop;
	
	private int maxCounterValue;
	private int count;
	private Thread thread;
	private Logger log  = Logger.getLogger("TwoThreadsCounter");

	/**
	 * Constructor. Create thread with given name and start it.
	 * Set max allowed counter value.
	 * 
	 * @param maxCounterValue - max allowed counter value
	 * @param threadName - thread name
	 */
	public TwoThreadsCounter(int maxCounterValue, String name) {
		
		if(name == null) {
			log.warning("Thread name can not be null");
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
	synchronized public void run() {
		
		while (count < maxCounterValue) {
			try {
				wait(1000);
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