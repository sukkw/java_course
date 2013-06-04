package com.sirma.itt.javacourse.threads;

/**
 * TwoThreadsCounter run class. Starts threads.
 * 
 * @version 1.1 04 Jun 2013
 * @author Stella Djulgerova
 */
public class TwoThreadsCounterRun {

	/**
	 * Class main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TwoThreadsCounter threadOne = new TwoThreadsCounter(10, "Thread1");
		TwoThreadsCounter threadTwo = new TwoThreadsCounter(20, "Thread2");
	}
}
