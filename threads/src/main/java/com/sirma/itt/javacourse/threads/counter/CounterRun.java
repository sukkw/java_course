package com.sirma.itt.javacourse.threads.counter;

import com.sirma.itt.javacourse.io.ConsoleReader;

/**
 * Counter run class. Starts thread and stops it when
 * a key is pressed
 * 
 * @version 1.1 04 Jun 2013
 * @author Stella Djulgerova
 */
public class CounterRun {

	/**
	 * Class main method. 
	 * @param args
	 */
	public static void main(String[] args) {
		
		long maxCounterValue = 2000000000;
		Counter counter = new Counter(maxCounterValue);
		counter.start();
		System.out.println("Counter is started...");
		ConsoleReader.readString();			
		counter.stopCounter();
		System.out.println("Counter is stopped to : " + counter.getValue());
	}
}