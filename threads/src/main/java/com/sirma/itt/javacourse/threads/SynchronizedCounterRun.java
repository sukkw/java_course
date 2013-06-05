package com.sirma.itt.javacourse.threads;

/**
 * SynchronizedCounter run class. Starts threads.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class SynchronizedCounterRun {

	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SynchronizedCounter synchConter = new SynchronizedCounter();

		SynchronizedThread ct1 = new SynchronizedThread(10, synchConter, "Thread1");
		SynchronizedThread ct2 = new SynchronizedThread(10, synchConter, "Thread2");
	}
}