package com.sirma.itt.javacourse.threads;

/**
 * SynchronizedCounter class. Call wait and notify methods to
 * make two threads run one after another.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class SynchronizedCounter {
	
	// detect which thread is last run
	private boolean lastRun;
	
	/**
	 * Synchronize work of two threads.
	 * 
	 * @param name - currently running thread name
	 */
	synchronized public void synchronize(int count, boolean runningThread, String threadName) {
		
		if(threadName == null ) {
			System.out.println("Invalid params!");
			return;
		}
		
		// if first thread is running let it wait
		while(lastRun == runningThread){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		// change current thread state
		if(lastRun){
			lastRun= false;
		}else {
			lastRun=true;
		}
		
		System.out.println(threadName + " ---> "+ count);
		notify();
	}
}