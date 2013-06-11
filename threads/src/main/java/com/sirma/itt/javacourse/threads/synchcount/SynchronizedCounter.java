package com.sirma.itt.javacourse.threads.synchcount;

import java.util.logging.Logger;

/**
 * SynchronizedThread class. Create and starts thread. Increase value of the
 * counter with 1 each second while the thread is running. Threads are running
 * one after another.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class SynchronizedCounter extends Thread {

	// class private members
	private int maxCounterValue;
	private int counter;

	/**
	 * Constructor. Create thread with given name and start it. Initialize all
	 * variables.
	 * 
	 * @param maxCounterValue - max allowed counter value
	 */
	public SynchronizedCounter(int maxCounterValue) {
		this.maxCounterValue = maxCounterValue;
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
			synchronized (getClass()) {
				try {
					Thread.sleep(500);
					print();
					notifyAll();
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			counter++;
		}
	}

	protected void print() {
		System.out.println(Thread.currentThread().getName()
				+ " ----> " + counter);
	}
}