package com.sirma.itt.javacourse.threads;

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

		SleepingCounter threadOne = new SleepingCounter(10, "ThreadOne");
		SleepingCounter threadTwo = new SleepingCounter(20, "ThreadTwo");
	}
}
