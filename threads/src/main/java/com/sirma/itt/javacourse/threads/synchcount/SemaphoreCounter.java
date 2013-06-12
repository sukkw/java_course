package com.sirma.itt.javacourse.threads.synchcount;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreCounter class. Increase value of the
 * counter with 1 each second while the thread is running. 
 * Threads are running one after another using semaphores.
 * 
 * @version 1.1 12 Jun 2013
 * @author Stella Djulgerova
 */
public class SemaphoreCounter  extends Thread {
	
	// class private members
	private int maxCounterValue;
    int counter;
    Semaphore ins, outs;

    /**
     * Constructor.
	 * Initialize all variables.
     * 
     * @param maxCounterValue - max allowed counter value
     * @param ins - semaphore for first thread
     * @param outs - semaphore for second thread
     */
    SemaphoreCounter(int maxCounterValue, Semaphore ins, Semaphore outs) {
        this.maxCounterValue = maxCounterValue;
        this.ins = ins;
        this.outs = outs;
    }

	/**
	 * Increments counter with 1 each second until max allowed counter value is
	 * reached. Synchronize threads to work one after another.
	 */
    public void run() {
        for (int i = 0; i < maxCounterValue; i++) {
            try {
				ins.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
            print();
            outs.release();  // allow another thread to run
            counter ++;
        }
    }
    
	/**
	 * Print information about currently running thread
	 */
	protected void print() {
		System.out.println(Thread.currentThread().getName() + " ---> " + counter);
	}
}