package com.sirma.itt.javacourse.threads.hash;

/**
* Timeout thread. Check if element of hashtable is recently in use
* and sleep for 10 seconds.
*
* @version 1.1 09 Jun 2013
* @author Stella Djulgerova
*/
public class Timeout implements Runnable {

	// class private members
	private Thread thread;
	private TimeoutHashtable table;

	/**
	 * Constructor. Initialize all variables and start thread.
	 * @param table - hashtable with elements
	 * @param name - thread name
	 */
	public Timeout(TimeoutHashtable table, String name) {
		thread = new Thread(this, name);
		thread.start();
		this.table = table;
	}
	
	/**
	 * Notify thread when hashtable element is used.
	 */
	public synchronized void notifyThread() {
		notify();
	}
	
	/**
	 * If element has been not used in the last 10 seconds try to remove it from table.
	 */
	public synchronized void run() {
		while (!table.isUsed()) {
			try {
				wait(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(!table.isUsed()) {
				break;
			} else {
				table.setUsed(false);
			}
		}
		
		table.remove(thread.getName());

		return;	
	}
}