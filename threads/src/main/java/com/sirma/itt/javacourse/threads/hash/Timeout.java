package com.sirma.itt.javacourse.threads.hash;

/**
 * Timeout thread. Check if element of hashtable is recently in use and sleep
 * for 10 seconds.
 * 
 * @version 1.1 09 Jun 2013
 * @author Stella Djulgerova
 */
public class Timeout extends Thread {

	// class private members
	private TimeoutHashtable table;
	private int time;

	/**
	 * Constructor. Initialize all variables.
	 * 
	 * @param table - hashtable with elements
	 * @param name - thread name
	 */
	public Timeout(TimeoutHashtable table, int time) {
		this.table = table;
		this.time = time;
	}

	/**
	 * Notify thread when hashtable element is used.
	 */
	public synchronized void notifyThread() {
		notify();
	}

	/**
	 * If element has been not used in the last 10 seconds try to remove it from
	 * table.
	 */
	public void run() {
		while (!table.isUsed()) {
			synchronized (this) {
				try {
					wait(time * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (!table.isUsed()) {
				break;
			} else {
				table.setUsed(false);
			}
		}
		table.remove(this.getName());

		return;
	}
}