package com.sirma.itt.javacourse.threads.sleep;

/**
 * WaitingCounter run class. Starts threads.
 * 
 * @version 1.1 04 Jun 2013
 * @author Stella Djulgerova
 */
public class WaitingCounterRun {

	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		WaitingCounter threadOne = new WaitingCounter(20, 1000);
		threadOne.setName("ThreadOne");
		threadOne.start();
		
		WaitingCounter threadTwo = new WaitingCounter(20, 1000);
		threadTwo.setName("ThreadTwo");
		threadTwo.start();
	}
}
