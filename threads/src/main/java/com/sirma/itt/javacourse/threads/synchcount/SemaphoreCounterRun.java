package com.sirma.itt.javacourse.threads.synchcount;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreCounter run class. Starts threads.
 * 
 * @version 1.1 12 Jun 2013
 * @author Stella Djulgerova
 */
public class SemaphoreCounterRun {
	
	/**
	 * Class main method.
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
    	
    	// first thread run immediately
    	Semaphore semaphopreOne = new Semaphore(1);  
    	// second thread has to wait
    	Semaphore semaphoreTwo = new Semaphore(0); 
    	
    	
    	SemaphoreCounter firstThread = new SemaphoreCounter(1000, semaphopreOne, semaphoreTwo);
    	firstThread.setName("ThreadOne");
    	firstThread.start();
    	SemaphoreCounter secondThread = new SemaphoreCounter(1000, semaphoreTwo, semaphopreOne); 
    	secondThread.setName("ThreadTwo");
    	secondThread.start();
	}
}