package com.sirma.itt.javacourse.threads.synchcount;

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
	private static Object object = new Object();

	/**
	 * Constructor.
	 * Initialize all variables.
	 * 
	 * @param maxCounterValue - max allowed counter value
	 */
	public SynchronizedCounter(int maxCounterValue) {
		this.maxCounterValue = maxCounterValue;
	}

	/**
	 * Increments counter with 1 each second until max allowed counter value is
	 * reached. Synchronize threads to work one after another.
	 */
	public void run() {
		while (counter < maxCounterValue) {
			synchronized (object) {
				try {
					Thread.sleep(500);
					print();
					object.notify();
					object.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			counter++;
		}
	}

	/**
	 * Print information about currently running thread
	 */
	protected void print() {
		System.out.println(Thread.currentThread().getName()
				+ " ----> " + counter);
	}
}