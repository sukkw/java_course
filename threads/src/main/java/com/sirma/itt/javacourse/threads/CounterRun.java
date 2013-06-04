package com.sirma.itt.javacourse.threads;

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
		
		int maxCounterValue = 86400;
		Counter c = new Counter(maxCounterValue);
		System.out.println("Counter is started...");
		ConsoleReader.readString();			
		c.getThread().interrupt();
		System.out.println("Counter is stopped to : " + c.getNumber());
	}
}