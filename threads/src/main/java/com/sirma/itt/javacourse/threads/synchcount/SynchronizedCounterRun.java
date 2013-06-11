package com.sirma.itt.javacourse.threads.synchcount;


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

		SynchronizedCounter threadOne = new SynchronizedCounter(10);
		threadOne.setName("ThreadOne");
		threadOne.start();
		
		SynchronizedCounter threadTwo = new SynchronizedCounter(10);
		threadOne.setName("ThreadOne");
		threadOne.start();
	}
}