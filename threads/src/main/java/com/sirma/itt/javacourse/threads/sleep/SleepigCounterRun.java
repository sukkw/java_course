package com.sirma.itt.javacourse.threads.sleep;

/**
 * SleepigCounter run class. Starts threads.
 * 
 * @version 1.1 04 Jun 2013
 * @author Stella Djulgerova
 */
public class SleepigCounterRun {

	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SleepingCounter threadOne = new SleepingCounter(20);
		threadOne.setName("ThreadOne");
		threadOne.start();
		
		SleepingCounter threadTwo = new SleepingCounter(20);
		threadTwo.setName("ThreadTwo");
		threadTwo.start();
	}
}
