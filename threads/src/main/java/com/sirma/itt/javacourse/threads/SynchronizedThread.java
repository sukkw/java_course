package com.sirma.itt.javacourse.threads;

import java.util.logging.Logger;

/**
 * SynchronizedThread class. Create and starts thread. 
 * Increase value of the counter with 1 each second while the thread is running.
 * Threads are running one after another.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class SynchronizedThread implements Runnable {

	// class private members
	private SynchronizedCounter synchConter;
	private int maxCounterValue;
	private String name;
	private Thread thread;
	private int count;
	private Logger LOGGER = Logger.getLogger("SynchronizedThread");
	
	/**
	 * Constructor. Create thread with given name and start it.
	 * Initialize all variables.
	 * 
	 * @param maxCounterValue - max allowed counter value
	 * @param synchConter - synchronization object
	 * @param threadName - thread name
	 */
	public SynchronizedThread(int maxCounterValue, SynchronizedCounter synchConter,
			String name) {
		
		if(name == null || synchConter == null) {
			LOGGER.warning("Invalid params!");
			return;
		}
		
		this.synchConter = synchConter;
		this.maxCounterValue = maxCounterValue;
		this.name = name;
		thread = new Thread(this, name);
		thread.start();
	}

	/**
	 * Increments counter with 1 each second until max allowed counter value
	 * is reached. Synchronize threads to work one after another.
	 */
	public void run() {
		while(count < maxCounterValue) {
			try {
				thread.sleep(1000);
				synchConter.synchronize(count, thread.getName());
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}