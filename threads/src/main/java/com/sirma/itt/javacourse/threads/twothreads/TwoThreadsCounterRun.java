package com.sirma.itt.javacourse.threads.twothreads;


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
		TwoThreadsCounter threadOne = new TwoThreadsCounter(990);
		threadOne.setName("ThreadOne");
		threadOne.start();

		TwoThreadsCounter threadTwo = new TwoThreadsCounter(1000);
		threadTwo.setName("ThreadTwo");
		threadTwo.start();
	}
}
