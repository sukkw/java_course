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

		SynchronizedCounter ct1 = new SynchronizedCounter(10, "Thread1");
		SynchronizedCounter ct2 = new SynchronizedCounter(10, "Thread2");
	}
}