package com.sirma.itt.javacourse.threads.warehouse;

/**
 * Consumer thread. Try to get stocks from warehouse 
 * and sleeps for specified time.
 * 
 * @version 1.1 10 Jun 2013
 * @author Stella Djulgerova
 */
class Consumer extends Thread {

	// class private members
	private int time;
	private Warehouse warehouse;

	/**
	 * Constructor. Initialize all variables.
	 * 
	 * @param time - how long thread has to sleep after add attempt.
	 * @param warehouse - reference to warehouse
	 */
	public Consumer(int time, Warehouse warehouse) {		
		this.time = time;
		this.warehouse = warehouse;
	}

	/**
	 * Try to get from warehouse and sleeps.
	 */
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				warehouse.getStock((int) (1 + (Math.random() * 10)));
				sleep(time);
			} catch (InterruptedException e) {
			}
		}
	}
}