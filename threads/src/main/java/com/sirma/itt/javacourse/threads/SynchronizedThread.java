package com.sirma.itt.javacourse.threads;

import java.util.logging.Logger;

/**
 * SynchronizedThread class. Create and starts thread. Increase value of the
 * counter with 1 each second while the thread is running. Threads are running
 * one after another.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class SynchronizedThread implements Runnable {

	// class private members
	private int maxCounterValue;
	private String name;
	private static Thread thread;
	private int counter;
	private Logger LOGGER = Logger.getLogger("SynchronizedThread");

	/**
	 * Constructor. Create thread with given name and start it. Initialize all
	 * variables.
	 * 
	 * @param maxCounterValue - max allowed counter value
	 * @param synchConter - synchronization object
	 * @param threadName - thread name
	 */
	public SynchronizedThread(int maxCounterValue, String name) {

		if (name == null) {
			LOGGER.warning("Invalid params!");
			return;
		}

		this.maxCounterValue = maxCounterValue;
		this.name = name;
		thread = new Thread(this, name);
		thread.start();
	}

	/**
	 * Run thread and call counter.
	 */
	public void run() {
		counter();
	}

	/**
	 * Increments counter with 1 each second until max allowed counter value is
	 * reached. Synchronize threads to work one after another.
	 */
	private void counter() {

		while (counter < maxCounterValue) {
			synchronized (thread) {
				try {
					thread.sleep(500);
					System.out.println(Thread.currentThread().getName()
							+ " ----> " + counter);
					thread.notify();
					thread.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			counter++;
		}
	}
}