package com.sirma.itt.javacourse.threads.sleep;

public class WaitingCounter extends Thread {

	// this flag will be raised when threads have to stop.
	private static boolean stop;
	
	private int counter;
	private int maxCounterValue;
	
	/**
	 * Constructor. Create thread and start it.
	 * Set max allowed counter value.
	 * 
	 * @param maxCounterValue - max allowed counter value
	 */
	public WaitingCounter(int maxCounterValue) {
		this.maxCounterValue = maxCounterValue;
	}
	
	/**
	 * Increments counter with 1 each second until max allowed counter value
	 * is reached.
	 */
	public synchronized void run() {
		
		while (counter < maxCounterValue) {
			try {
				wait(1000);
				System.out.println(this.getName() + " ---> " + counter);
				counter++;
			} catch (InterruptedException e) {
				return;
			}
			if ( counter == maxCounterValue ) {
				stop = true;
			}
			if (stop) return;
		}
	}
}