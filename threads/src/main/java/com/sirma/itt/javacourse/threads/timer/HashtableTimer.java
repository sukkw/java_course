package com.sirma.itt.javacourse.threads.timer;

import java.util.TimerTask;

/**
 * HashtableTimer class. Remove expired elements.
 * 
 * @version 1.1 12 Jun 2013
 * @author Stella Djulgerova
 */
public class HashtableTimer extends TimerTask {

	// class private members
	private String key;
	private TimeoutHashtable table;
	
	/**
	 * Constructor. Initialize variables.
	 * @param table - TimeoutHashtable
	 * @param key - element to remove key
	 */
	public HashtableTimer(TimeoutHashtable table, String key) {
		this.key = key;
		this.table = table;
	}
	
	public void run() {
		table.remove(key);
	}
}
