package com.sirma.itt.javacourse.threads.warehouse;

/**
 * Producer thread. Try to put stocks to warehouse and sleeps for specified
 * time.
 * 
 * @version 1.1 10 Jun 2013
 * @author Stella Djulgerova
 */
class Producer extends Thread {

	// class private members
	private int time;
	private Warehouse warehouse;

	/**
	 * Constructor. Initialize all variables.
	 * 
	 * @param time - how long thread has to sleep after add attempt.
	 * @param warehouse - reference to warehouse
	 */
	public Producer(int time, Warehouse warehouse) {
		this.time = time;
		this.warehouse = warehouse;
	}

	/**
	 * Try to add to warehouse and sleeps.
	 */
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				warehouse.putStock((int) (1 + (Math.random() * 10)));
				sleep(time * 1000);
			} catch (InterruptedException e) {
			}
		}
	}
}