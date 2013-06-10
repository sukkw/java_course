package com.sirma.itt.javacourse.threads;

/**
 * SynchronizedCounter class. Call wait and notifyAll methods to
 * make two threads run one after another.
 * 
 * @version 1.1 05 Jun 2013
 * @author Stella Djulgerova
 */
public class SynchronizedCounter {
	
	// keep the name of currently running thread
	private String runnigThreadName = "Thread1";
	
	/**
	 * Synchronize work of two threads.
	 * 
	 * @param name - currently running thread name
	 */
	synchronized public void synchronize(int count, String name) {
		
		if(name == null ) {
			System.out.println("Invalid params!");
			return;
		}
		
		// if first thread is running let it wait
		while(!runnigThreadName.equals(name)){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		// change current thread name
		if(runnigThreadName.equals("Thread1")){
			runnigThreadName = "Thread2";
		}else {
			runnigThreadName = "Thread1";
		}
		
		System.out.println(name + " ---> "+ count);
		notify();
	}
}